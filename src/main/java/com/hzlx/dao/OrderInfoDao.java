package com.hzlx.dao;

import com.hzlx.entity.OrderInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrderInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    BigDecimal getExpectedIncome(Integer id);

    List<Map<String, Object>> getPendingOrderList(int id);

    int updateOrderForStatus(Integer orderId,Integer businessId, int status);

    /**
     *    获取指定商家待处理订单数量
     * @param businessId
     * @return
     */
    Long Pending(Integer businessId);
}