package com.hzlx.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * t_food_info
 * @author 
 */
public class FoodInfo implements Serializable {
    private Integer id;

    /**
     * 商家ID
     */
    private Integer businessId;

    /**
     * 菜名
     */
    private String name;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 在售状态 0 售罄  1在售
     */
    private Integer ment;

    /**
     * 状态 0 无效  1正常
     */
    private Integer status;

//    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getMent() {
        return ment;
    }

    public void setMent(Integer ment) {
        this.ment = ment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}