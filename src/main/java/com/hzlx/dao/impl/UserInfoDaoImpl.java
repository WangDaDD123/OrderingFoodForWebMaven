package com.hzlx.dao.impl;

import com.hzlx.dao.BaseDao;
import com.hzlx.dao.UserInfoDao;
import com.hzlx.entity.UserInfo;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/3/29 11:03
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(UserInfo record) {
        String sql = "insert into t_user_info values(null,?,?,?,?,default,now())";
        return executeUpdate(sql,
                record.getNickName(),
                record.getUserName(),
                record.getPassword(),
                record.getTel()
        );
    }

    @Override
    public UserInfo selectUserInfoByUserNameAndPwd(String userName, String pwd) {
        String sql = "select * from t_user_info where user_name=? and `password`=?";
        return executeQueryObject(sql, UserInfo.class, userName, pwd);
    }
}
