<%--
  Created by IntelliJ IDEA.
  User: muyan
  Date: 2023/4/5
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="url" value="<%=request.getContextPath()%>"></c:set>
<html>
<head>
    <title>(>^ω^<)：吃了喵点餐平台-商家版</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        @import "${url}/css/index.css";
        @import "${url}/css/bus_login.css";
    </style>
    <script src="${url}/js/jquery.min.js"></script>
<%--    <script src="${url}/js/bus_login.js"></script>--%>
</head>
<body>
<h1 class="title">吃了喵-商家版</h1>
<img class="logo" src="${url}/images/bus_logo.png"/>
<div class="login_box">
<%--    <form action="" method="post" onsubmit="return false">--%>
        <form action="${url}/busLogin.do" method="post" >
        <table>
            <tr>
                <td class="l_td">用户名：</td>
                <td class="r_td"><input id="userName" name="userName" type="text"></td>
            </tr>
            <tr>
                <td class="l_td">密码：</td>
                <td class="r_td"><input id="pwd" name="pwd" type="password"></td>
            </tr>
            <tr>
                <td></td>
                <td> <button class="sub_btn" type="submit">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</button></td>
            </tr>
        </table>
    </form>
    <div>还没有账号？<a href="register.jsp">去注册</a></div>
</div>

<div class="register_box">
    <form>

    </form>
</div>
</body>
</html>
