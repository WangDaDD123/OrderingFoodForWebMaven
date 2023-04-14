package com.hzlx.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * t_business_info
 * @author 
 */
public class BusinessInfo implements Serializable {
    private Integer id;

    /**
     * 店名
     */
    private String name;

    /**
     * 登录账号
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 入驻时间
     */
    private LocalDateTime createTime;

    /**
     * 营业状态 0 打烊  1 营业
     */
    private Integer jobType;

    /**
     * 状态 0 无效 1正常
     */
    private Integer status;

//    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}