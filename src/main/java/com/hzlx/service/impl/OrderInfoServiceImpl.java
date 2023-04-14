package com.hzlx.service.impl;

import com.google.gson.Gson;
import com.hzlx.dao.OrderInfoDao;
import com.hzlx.dao.impl.OrderInfoDaoImpl;
import com.hzlx.entity.BusinessInfo;
import com.hzlx.entity.RespBean;
import com.hzlx.service.OrderInfoService;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/4/10 11:51
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class OrderInfoServiceImpl implements OrderInfoService {
    private OrderInfoDao orderInfoDao = new OrderInfoDaoImpl();

    @Override
    public String takeOrder(HttpServletRequest req) {
        RespBean respBean;
        //从session中获取登录的商家信息
        BusinessInfo businessInfo = (BusinessInfo)req.getSession().getAttribute("businessInfo");
        //获取请求参数-->订单编号

        Integer orderId = Integer.parseInt(req.getParameter("orderId"));
        //调用dao修改订单状态
        int rows=orderInfoDao.updateOrderForStatus(orderId, businessInfo.getId(),2);
        if (rows>0){
             respBean=RespBean.success();
        }else {
            respBean=RespBean.error(10010,"修改订单状态失败");
        }
        Gson gson=new Gson();
        return gson.toJson(respBean);
    }
}
