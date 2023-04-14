package com.hzlx.controller;

import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * 商家登录接口
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/4/5 10:45
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@WebServlet(urlPatterns = "/busLogin.do")
public class BusLoginController extends HttpServlet {
    //商家业务层
    private BusinessInfoService businessInfoService = new BusinessInfoServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /*
       //设置请求编码格式为 UTF-8
        req.setCharacterEncoding("UTF-8");
        //获取请求中的数据
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        //调用service中的登录方法
        BusinessInfo businessInfo = businessInfoService.login(userName, pwd);

        RequestDispatcher requestDispatcher;
        if (null != businessInfo) {
            //登录成功转发到home.jsp
            requestDispatcher = req.getRequestDispatcher("/pages/business/home.jsp");
        } else {
            //登录失败？转发到login.jsp
            requestDispatcher = req.getRequestDispatcher("/pages/business/login.jsp");
        }
        requestDispatcher.forward(req, resp);
        */
        //调用service层的login方法，返回转发的url
        String url = businessInfoService.login(req, resp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        requestDispatcher.forward(req,resp);
    }
}
