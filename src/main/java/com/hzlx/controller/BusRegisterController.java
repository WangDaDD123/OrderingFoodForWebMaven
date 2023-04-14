package com.hzlx.controller;

import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;
import com.hzlx.utils.WebUrlUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/4/7 10:46
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@WebServlet(urlPatterns = "/register.do")
public class BusRegisterController extends HttpServlet {
    private BusinessInfoService businessInfoService=new BusinessInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用service中的注册方法
        String url = businessInfoService.register(req);
        //重定向到登录
        resp.sendRedirect(WebUrlUtil.getUrl(req)+url);
    }


}
