package com.hzlx.controller;

import com.hzlx.service.OrderInfoService;
import com.hzlx.service.impl.OrderInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 接单的Controller
 * @author: Mr、哈喽沃德
 * @Date: 2023/4/10 11:29
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@WebServlet(urlPatterns = "/takeOrder.do")
public class TakeOrderController extends HttpServlet {
    private OrderInfoService orderInfoService=new OrderInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        resp.getWriter().write(orderInfoService.takeOrder(req));
    }
}
