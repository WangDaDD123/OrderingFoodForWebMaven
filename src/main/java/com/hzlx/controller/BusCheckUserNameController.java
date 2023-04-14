package com.hzlx.controller;

import com.hzlx.service.BusinessInfoService;
import com.hzlx.service.impl.BusinessInfoServiceImpl;

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
 * @Date: 2023/4/7 9:15
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@WebServlet(urlPatterns = "/busCheckUserName.do")
public class BusCheckUserNameController extends HttpServlet {
    private BusinessInfoService businessInfoService = new BusinessInfoServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer rows = businessInfoService.checkUserName(req, resp);
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        resp.getWriter().write(rows.toString());
    }
}
