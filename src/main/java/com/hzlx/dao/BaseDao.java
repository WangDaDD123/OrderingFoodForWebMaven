package com.hzlx.dao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author: Mr、晓航
 * @Date: 2023/3/10 10:27
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseDao<T> {
    /**
     * 新增|修改|删除  公用的方法
     *
     * @param sql    执行的SQL  insert into user_info values(null,?,?,?)
     * @param params 参数列表 它是一个可变参数（0~N个）
     * @return 受影响行数
     */
    public int executeUpdate(String sql, Object... params) {
        //1.获取链接 （从连接池中拿出链接）
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        int rows = -1;
        try {
            //准备SQL  不需要准备sql  因为sql是通过参数传递进来的
            //2.获取预执行器
            preparedStatement = connection.prepareStatement(sql);
            //3.替换？
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            //4.执行SQL
            rows = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            //5.关闭资源
            try {
                preparedStatement.close();
                //归还资源
                ConnectionPool.returnConnection(connection);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return rows;
    }

    /**
     * 封装公共的查询方法
     *
     * @param sql    待执行的SQL
     * @param zClass 类的字节码对象
     * @param params 参数列表
     * @return 结果集合
     */
    public List<T> executeQuery(String sql, Class zClass, Object... params) {
        //准备装数据的集合
        List<T> list = null;
        //1.获取链接
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //2.获取预执行器
            preparedStatement = connection.prepareStatement(sql);
            //3.替换？
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            //4.执行SQL，获取结果集
            resultSet = preparedStatement.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()) {
                try {
                    //通过反射创建对象[newInstance() 调用的是类的无参构成器]
                    Object obj = zClass.newInstance();
                    //获取类的多有属性
                    Field[] fields = zClass.getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
//                        fields[i].getName();
                        //设置私有属性可见（暴力反射）
                        fields[i].setAccessible(true);
                        //通过反射给属性赋值
                        fields[i].set(obj, resultSet.getObject(i + 1));
                    }
                    //把数据放进集合中去
                    list.add((T) obj);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            //关闭资源
            try {
                resultSet.close();
                preparedStatement.close();
                //归还
                ConnectionPool.returnConnection(connection);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 把结果封装成一个具体的对象
     *
     * @param sql    执行的sql
     * @param zClass 封装对象的字节码
     * @param params 参数列表
     * @return T
     */
    public T executeQueryObject(String sql, Class zClass, Object... params) {
        //1.获取链接
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //通过反射创建对象[newInstance() 调用的是类的无参构成器]
        Object obj = null;
        try {
            //2.获取预执行器
            preparedStatement = connection.prepareStatement(sql);
            //3.替换？
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            //4.执行SQL，获取结果集
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                try {
                    obj = zClass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                //如果反射创建对象失败 直接返回null
                if (obj == null) {
                    return null;
                }

                try {
                    //获取类的多有属性
                    Field[] fields = zClass.getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
//                        fields[i].getName();
                        //设置私有属性可见（暴力反射）
                        fields[i].setAccessible(true);
                        //通过反射给属性赋值
                        fields[i].set(obj, resultSet.getObject(i+1));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            //关闭资源
            try {
                resultSet.close();
                preparedStatement.close();
                //归还
                ConnectionPool.returnConnection(connection);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }
        return (T) obj;
    }


    /**
     * 把结果集封装成一个map集合
     *
     * @param sql    执行的sql
     * @param params 参数列表
     * @return 结果集
     */
    public Map<String, Object> executeQueryMap(String sql, Object... params) {
        //定义一个map容器
        Map<String, Object> map = new HashMap<>();
        //1.获取链接 从连接池中拿出一个链接
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //2.获取一个sql预执行器
        try {
            preparedStatement = connection.prepareStatement(sql);
            //替换？
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            //拿到结果集
            resultSet = preparedStatement.executeQuery();
            //从结果集中获取列的属性对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            //拼装map
            int columnCount = metaData.getColumnCount();//结果集中一共有多少列
            resultSet.next();//resultSet 指针下移一次
            for (int i = 1; i <= columnCount; i++) {
                map.put(metaData.getColumnLabel(i), resultSet.getObject(i));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
            ConnectionPool.returnConnection(connection);
        }
        return map;
    }


    public List<Map<String, Object>> executeQueryListMap(String sql, Object... params) {
        //定义一个list容器
        List<Map<String,Object>> list=new ArrayList<>();

        //1.获取链接 从连接池中拿出一个链接
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //2.获取一个sql预执行器
        try {
            preparedStatement = connection.prepareStatement(sql);
            //替换？
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            //拿到结果集
            resultSet = preparedStatement.executeQuery();
            //从结果集中获取列的属性对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            //拼装map
            int columnCount = metaData.getColumnCount();//结果集中一共有多少列
            while (resultSet.next()){
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(metaData.getColumnLabel(i), resultSet.getObject(i));
                }
                list.add(map);
            }
//            resultSet.next();//resultSet 指针下移一次

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
            ConnectionPool.returnConnection(connection);
        }
        return list;
    }
}
