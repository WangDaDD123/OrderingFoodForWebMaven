package com.hzlx.controller;

import com.hzlx.service.SysRegionService;
import com.hzlx.service.impl.SysRegionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *       =====================================  三级联动 =======================================
 */

@WebServlet(urlPatterns = "/sysRegion.do")
public class SysRegionController extends HttpServlet {
    // 引入三级联动Service
    private SysRegionService sysRegionService=new SysRegionServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 业务层 处理完成之后响应给前端的JSON字符串
        String respStrForJSON=sysRegionService.queryAddress(req);
        // 修改影响的编码格式
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        // 把Service层中返回的JSON字符串通过Response写出
        resp.getWriter().write(respStrForJSON);

    }
}
