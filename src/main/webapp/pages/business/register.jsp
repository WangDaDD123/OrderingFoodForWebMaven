<%--
  Created by IntelliJ IDEA.
  User: muyan
  Date: 2023/4/7
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("url", "http://localhost:8080/OrderingFoodForWebMaven");%>

<html>
<head>
    <title>吃了喵-商家注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        @import "${url}/css/index.css";
        @import "${url}/css/bus_login.css";

        .zz {
            padding-top: 10px;
            margin: 0 100px;
            color: white;
        }

        .zz a {
            font-size: 20px;
            color: white;
            text-decoration: none;
        }
    </style>
    <%--    引入外部js--%>
    <script src="${url}/js/bus_register.js"></script>
</head>
<body>
<h1 class="title">香的嘞-商家版</h1>
<img src="${url}/images/bus_logo.png" class="logo">

<div class="register_box">
    <form action="${url}/register.do" onsubmit="return subForm()">
        <table>
            <tr>
                <td class="l_td">店名:</td>
                <td class="r_td"><input name="name" type="text"></td>
            </tr>
            <tr>
                <td class="l_td">账号:</td>
                <td class="r_td">
                    <input id="userName" name="userName" type="text" onblur="checkUserName()"><br>
                    <span id="userNameMsg" style="color: tomato"></span>
                </td>
            </tr>
            <tr>
                <td class="l_td">密码:</td>
                <td class="r_td"><input name="password" type="text"></td>
            </tr>
            <tr>
                <td class="l_td">地址:</td>
                <td class="r_td"><input name="address" type="text"></td>
            </tr>
            <tr>
                <td class="l_td">电话:</td>
                <td class="r_td"><input name="tel" type="text"></td>
            </tr>
        </table>
        <button class="sub_btn" type="submit">注册</button>
        <div class="zz">还没有账号?<a href="login.jsp">去登陆</a></div>
    </form>
    </form>
</div>
</body>
</html>
