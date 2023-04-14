package com.hzlx.dao;


import com.hzlx.entity.UserInfo;

public interface UserInfoDao {
    /**
     * 根据主键删除用户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增用户
     * @param record
     * @return
     */
    int insert(UserInfo record);

    /**
     * 根据用户名和密码查询用户信息
     * @param userName 用户名
     * @param pwd 密码
     * @return  用户对象
     */
    UserInfo selectUserInfoByUserNameAndPwd(String userName,String pwd);
}