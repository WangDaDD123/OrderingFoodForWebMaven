package com.hzlx.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/4/7 11:24
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class WebUrlUtil {

    public static String getUrl(HttpServletRequest request){
        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        int len = requestURL.length() - requestURI.length();
        int i = requestURL.indexOf("/", len+1);
        return requestURL.substring(0,i);
    }

}
