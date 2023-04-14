package com.hzlx.dao.impl;

import com.hzlx.dao.BaseDao;
import com.hzlx.dao.FoodInfoDao;
import com.hzlx.entity.FoodInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * 菜品的dao层
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/3/25 14:08
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class FoodInfoDaoImpl extends BaseDao<FoodInfo> implements FoodInfoDao {
    @Override
    public List<FoodInfo> selectFoodInfoAll(Integer businessId) {
        String sql = "select * from t_food_info where `status`=1 and business_id=?";
        return executeQuery(sql, FoodInfo.class, businessId);
    }

    @Override
    public int insertFoodInfo(Integer businessId, String name, BigDecimal price) {
        String sql = "insert into t_food_info values(null,?,?,?,default,default)";
        return executeUpdate(sql, businessId, name, price);
    }

    @Override
    public int updateFoodInfoForPrice(FoodInfo foodInfo) {
        String sql = "update t_food_info set price=? where id=?";
        return executeUpdate(sql, foodInfo.getPrice(), 1/*foodInfo.getId()*/);
    }

    @Override
    public int updateFoodInfoSoldOut(Integer id, Integer newMent) {
        String sql = "update t_food_info set ment=? where id=?";
        return executeUpdate(sql, newMent, id);
    }

    @Override
    public int deleteFoodInfoById(Integer id) {
        String sql = "update t_food_info set `status`=0 where id=?";
        return executeUpdate(sql, id);
    }

    @Override
    public List<Map<String, Object>> getFoodInfos(String bName, Integer pageIndex, Integer pageSize) {
        String sql = "select tfi.id,\n" +
                "       tbi.name as bName,\n" +
                "       tfi.name as fName,\n" +
                "       tfi.price,\n" +
                "       tfi.ment,\n" +
                "       tfi.status\n" +
                "from t_food_info tfi\n" +
                "left join t_business_info tbi on tfi.business_id = tbi.id\n" +
                "where tbi.name like concat('%',?,'%') limit ?,?";
        return executeQueryListMap(sql, bName, pageIndex, pageSize);
    }

    @Override
    public Integer countFoodInfosByBName(String bName) {
        String sql = "select count(1) as count\n" +
                "from t_food_info tfi\n" +
                "left join t_business_info tbi on tfi.business_id = tbi.id\n" +
                "where tbi.name like concat('%',?,'%')";
        Map<String, Object> map = executeQueryMap(sql, bName);
        if (null == map) {
            return 0;
        }
        Long count = (Long) map.get("count");
        return count.intValue() ;
    }
}
