package com.hzlx.service;

import com.hzlx.entity.BusinessInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/4/5 10:51
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public interface BusinessInfoService {
    String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException;
    BusinessInfo login(String userName,String pwd);

    int checkUserName(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException;

    String register(HttpServletRequest req);

    /**
     * 跳转到商家的主页
     * @param request
     * @return
     */
    String goHome(HttpServletRequest request);
}
