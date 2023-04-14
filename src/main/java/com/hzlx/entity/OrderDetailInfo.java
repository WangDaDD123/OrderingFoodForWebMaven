package com.hzlx.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * t_order_detail_info
 * @author 
 */
public class OrderDetailInfo implements Serializable {
    private Integer id;

    /**
     * 订单编号
     */
    private Integer orderNo;

    /**
     * 菜id
     */
    private Integer foodId;

    /**
     * 数量
     */
    private Integer countNum;

    /**
     * 合计
     */
    private BigDecimal totalMoney;

//    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }
}