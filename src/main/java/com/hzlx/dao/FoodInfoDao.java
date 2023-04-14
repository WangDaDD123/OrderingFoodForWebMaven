package com.hzlx.dao;



import com.hzlx.entity.FoodInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface FoodInfoDao {
    /**
     * 根据businessId查询商家下所有的菜
     * @param businessId 商家ID
     * @return businessID对应的所有菜品
     */
    List<FoodInfo> selectFoodInfoAll(Integer businessId);

    /**
     * 菜品的新增
     * @param businessId  商家ID
     * @param name 菜品名字
     * @param price 菜品单价
     * @return 受影响行数
     */
    int insertFoodInfo(Integer businessId, String name, BigDecimal price);

    /**
     * 修改菜品信息
     * @param foodInfo
     * @return
     */
    int updateFoodInfoForPrice(FoodInfo foodInfo);

    /**
     * 根据ID售罄菜品
     * @param id
     * @return
     */
    int updateFoodInfoSoldOut(Integer id,Integer newMent);

    /**
     * 根据ID删除指定的菜品
     * @param id
     * @return
     */
    int deleteFoodInfoById(Integer id);

    /**
     * 根据商家名字模糊查询所有的菜
     * @param bName 商家名字
     * @return
     */
    List<Map<String,Object>> getFoodInfos(String bName, Integer pageIndex, Integer pageSize);

    /**
     * 根据商家名字模糊查询所有的菜总数
     * @param bName 商家名字
     * @return
     */
    Integer countFoodInfosByBName(String bName);
}