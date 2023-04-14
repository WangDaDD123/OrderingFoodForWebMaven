package com.hzlx.entity;

/**
 *   省市区地理表
 */
public class SysRegion {
    private String id;
    private String name;
    private String shortname;
    private String code;
    private String parentId;
    private Integer level;


    public SysRegion() {
    }

    public SysRegion(String id, String name, String shortname, String code, String parentId, Integer level) {
        this.id = id;
        this.name = name;
        this.shortname = shortname;
        this.code = code;
        this.parentId = parentId;
        this.level = level;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return shortname
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * 设置
     * @param shortname
     */
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    /**
     * 获取
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取
     * @return parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    public String toString() {
        return "SysRegion{id = " + id + ", name = " + name + ", shortname = " + shortname + ", code = " + code + ", parentId = " + parentId + ", level = " + level + "}";
    }
}
