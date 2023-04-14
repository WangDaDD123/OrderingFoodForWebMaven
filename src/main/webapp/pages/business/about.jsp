<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人中心</title>
    <style>
        @import url(../../css/business/about.css);
    </style>
    <script src="${ctx}/js/jumpMenu.js"></script>
</head>
<body>
    <div class="bgc_box"></div>
    <div class="body_box">
        <h1>商家中心</h1>
        <div class="bus_info">
            <img class="head_img" src="../../images/bus_head.jpg" />
            <div>
                <div>逍遥镇胡辣汤-涧西店</div>
                <div>TEL:188****8888</div>
                <div>Add:河南省洛阳市涧西区xxx路xx号</div>
            </div>
        </div>
        <div class="info_kp_box">
            <div class="info_kp">
                
            </div>
            <div class="info_kp_down"></div>
        </div>
        
        <div class="cy_menu"></div>
    </div>

        <!-- 底部菜单 -->
        <footer id="tabbar" class="tabbar">
            <div >
                <img src="../../images/bar/home.png" /><br>
                首页
            </div>
            <div >
                <img src="../../images/bar/order.png" /><br>
                订单
            </div>
            <div>
                <img src="../../images/bar/setting.png" /><br>
                管理
            </div>
            <div class="active">
                <img src="../../images/bar/about_active.png" /><br>
                我的
            </div>
        </footer>
</body>
</html>