package com.hzlx.entity;

public class RespBean {
    private long code;
    private String message;
    private Object data;

    public RespBean() {
    }

    public RespBean(long code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 成功返回结果
     */
    public static RespBean success() {
        return new RespBean(200, "success", null);
    }

    /**
     * 成功返回结果
     *
     * @param data
     */
    public static RespBean success(Object data) {
        return new RespBean(200,
                "success", data);
    }

    /**
     * 失败返回结果
     *
     * @param
     * @return
     */
    public static RespBean error(long code,String msg) {
        return new RespBean(code, msg,
                null);
    }

    /**
     * 获取
     *
     * @return code
     */
    public long getCode() {
        return code;
    }

    /**
     * 设置
     *
     * @param code
     */
    public void setCode(long code) {
        this.code = code;
    }

    /**
     * 获取
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取
     *
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置
     *
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }
}