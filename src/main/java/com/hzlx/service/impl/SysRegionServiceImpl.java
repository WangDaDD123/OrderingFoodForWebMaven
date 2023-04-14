package com.hzlx.service.impl;

import com.google.gson.Gson;
import com.hzlx.dao.SysRegionDao;
import com.hzlx.dao.impl.SysRegionDaoImpl;
import com.hzlx.entity.RespBean;
import com.hzlx.entity.SysRegion;
import com.hzlx.service.SysRegionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SysRegionServiceImpl implements SysRegionService {
    //在service层 引入数据访问层（Dao）
    private SysRegionDao sysRegionDao=new SysRegionDaoImpl();

    /**
     *              业务层查询地址
     * @param req
     * @return
     */
    @Override
    public String queryAddress(HttpServletRequest req) {
        RespBean resp;// 数据组装成RespBean
        // 获取强请求参数
        String parentId = req.getParameter("parentId");
        //根据parentId查询对象的地理位置集合
        List<SysRegion> addressList=sysRegionDao.getAddressByParentId(parentId);
        if (addressList!=null && addressList.size()>0){
            // 查到数据了 请求成功了  设置响应码为200 message为sucess data为addressList
            resp=RespBean.success(addressList);
        }else {
            // 查不到数据  设置相应码为10086 message为 data为查询失败
            resp=RespBean.error(10086,"查询失败");
        }
        // 将组装好的RespBean对象转成JSON字符串
        return new Gson().toJson(resp);
    }
}
