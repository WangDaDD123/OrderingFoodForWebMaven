package com.hzlx.dao;

import com.hzlx.entity.OrderDetailInfo;

public interface OrderDetailInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetailInfo record);

    int insertSelective(OrderDetailInfo record);

    OrderDetailInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderDetailInfo record);

    int updateByPrimaryKey(OrderDetailInfo record);
}