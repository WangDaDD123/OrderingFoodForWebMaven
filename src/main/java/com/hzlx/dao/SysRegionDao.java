package com.hzlx.dao;

import com.hzlx.entity.SysRegion;

import java.util.List;

public interface SysRegionDao {
    List<SysRegion> getAddressByParentId(String parentId);
}
