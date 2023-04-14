package com.hzlx.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * t_order_info
 * @author 
 */
public class OrderInfo implements Serializable {
    private Integer id;

    /**
     * 订单编号
     */
    private Integer orderNo;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 商家id
     */
    private Integer businessId;

    /**
     * 备注
     */
    private String desc;

    /**
     * 总价
     */
    private BigDecimal totalMoney;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态 0 退单  1 完成 2待支付
     */
    private Integer status;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}