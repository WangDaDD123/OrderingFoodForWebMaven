package com.hzlx.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Description:
 * 连接池
 *
 * @author: Mr、晓航
 * @Date: 2023/3/13 8:57
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionPool {
    //最小链接数
    private static int minSize = 5;
    //最大连接数
    private static int maxSize = 10;
    //链接池
    private static LinkedList<Connection> pool;

    private static String url;
    private static String userName;
    private static String password;
    private static String driver;

    //需要初始化连接池
    static {
        //实例化连接池
        pool = new LinkedList<>();
//        PropertiesUtil propertiesUtil = new PropertiesUtil("/jdbc.properties");
//        url = propertiesUtil.getPropertyForKey("url");
//        userName = propertiesUtil.getPropertyForKey("userName");
//        password = propertiesUtil.getPropertyForKey("password");
//        driver = propertiesUtil.getPropertyForKey("driver");
        url = "jdbc:mysql://127.0.0.1:3306/orderingfood?useSSl=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        userName = "root";
        password = "root";
        driver = "com.mysql.cj.jdbc.Driver";
        initConnection();

    }

    //初始化链接池
    private static void initConnection() {
        for (int i = 0; i < minSize; i++) {
            //调用addLast方法往连接池中存放
            Connection connection = null;
            try {
                //加载驱动
                Class.forName(driver);
                connection = DriverManager.getConnection(url, userName, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            pool.addLast(connection);
//            logger.info("第" + (i + 1) + "个链接对象：" + connection.hashCode());
        }
    }

    /**
     * 获取链接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        //TODO ???
        if (pool.size() <= 0) {
            try {
                //加载驱动
                Class.forName(driver);
                connection = DriverManager.getConnection(url, userName, password);
            } catch (Exception e) {
                e.printStackTrace();
//                logger.error("获取链接出错！", e);
            }
//            logger.info("获取新的链接是："+connection.hashCode());
            return connection;
        } else {
            //
            Connection connection1 = pool.removeFirst();
//            logger.info("获取池子中的链接是：" + connection1.hashCode());
            return connection1;
        }

    }

    /**
     * 归还链接
     *
     * @param connection 需归还的链接对象
     * @return 归还是否成功 true 成功  false 失败
     */
    public static boolean returnConnection(Connection connection) {
        /**
         * 归还的逻辑？
         *  如果连接池中已经存在10个链接里，那么这个要归还的链接是要被释放掉
         */
        if (pool.size() >= maxSize) {
            try {
                //释放连接（关闭资源）
//                logger.warn("链接池已满，无需归还！" + connection.hashCode());
                connection.close();
                return true;
            } catch (SQLException sqlException) {
//                logger.error("系统异常，归还失败！"+ connection.hashCode(),sqlException );
                return false;
            }
        } else {
            //归还链接
            pool.addLast(connection);
//            logger.info("归还成功！" + connection.hashCode());
            return true;
        }
    }
}
