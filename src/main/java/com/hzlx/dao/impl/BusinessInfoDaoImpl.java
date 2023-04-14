package com.hzlx.dao.impl;

import com.hzlx.dao.BaseDao;
import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.entity.BusinessInfo;

import java.util.Map;

/**
 * Description:
 *
 * @author: Mr、晓航
 * @Date: 2023/3/25 10:04
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class BusinessInfoDaoImpl extends BaseDao<BusinessInfo> implements BusinessInfoDao {

    @Override
    public int deleteByPrimaryKey(Integer id) {
        String sql = "update t_business_info set `status`=0 where id=?";
        return executeUpdate(sql, id);
    }

    @Override
    public int insert(BusinessInfo businessInfo) {
        String sql = "insert into t_business_info values(null,?,?,?,?,?,now(),default,default)";
        return executeUpdate(sql,
                businessInfo.getName(),
                businessInfo.getUserName(),
                businessInfo.getPassword(),
                businessInfo.getAddress(),
                businessInfo.getTel()
        );
    }

    @Override
    public BusinessInfo selectByPrimaryKey(Integer id) {
        String sql = "select * from t_business_info where id=?";
        return executeQueryObject(sql, BusinessInfo.class, id);
    }

    @Override
    public BusinessInfo selectBusinessInfoByUserNameAndPwd(String userName, String pwd) {
        String sql = "select * from t_business_info where user_name=? and `password`=?";
        return executeQueryObject(sql, BusinessInfo.class, userName, pwd);
    }

    @Override
    public int countBusinessInfoByUserName(String userName) {
        String sql = "select count(1) as count from t_business_info where user_name=?";
        Map<String, Object> map = executeQueryMap(sql, userName);
        return Integer.parseInt(map.get("count").toString());
    }

    @Override
    public int updateBusinessInfo(BusinessInfo businessInfo) {
        String sql = "update t_business_info set `name`=?,address=?,tel=? where id=?";
        return executeUpdate(
                sql,
                businessInfo.getName(),
                businessInfo.getAddress(),
                businessInfo.getTel(),
                businessInfo.getId()
        );
    }

    @Override
    public int updateBusinessInfoForJobType(Integer jobType, Integer id) {
        String sql = "update t_business_info set job_type=? where id=?";
        return executeUpdate(sql, jobType, id);
    }

    @Override
    public int updateBusinessInfoForPwd(String newPwd, Integer id) {
        String sql = "update t_business_info set password=? where id=?";
        return executeUpdate(sql, newPwd, id);
    }


}
