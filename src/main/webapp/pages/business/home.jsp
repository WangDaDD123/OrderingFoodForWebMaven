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
    <title>Document</title>
    <style>
        @import url(${ctx}/css/business/home.css);
    </style>
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/bus_home.js"></script>
    <script src="${ctx}/js/jumpMenu.js"></script>
</head>

<body>

    <div class="bgc_div"></div>
    <div class="body_box">
        <div class="top_div">
            <div class="business_name">${businessInfo.name}
            </div>

            <c:if test="${businessInfo.jobType==0}">
                <div class="yy_status">打烊</div>
            </c:if>
            <c:if test="${businessInfo.jobType==1}">
                 <div class="yy_status">营业中</div>
            </c:if>

        </div>

        <div class="tip">
            <div>
                <div>预计收入/元</div>
                <div>￥${totalMoney}</div>
            </div>
            <div>
                <div>待处理订单/单</div>
                <div>${pendingNum}</div>
            </div>
        </div>

        <div class="menu">
            <div>
                <img src="${ctx}/images/jz.png"/><br>
                结账

            </div>
            <div>
                <img src="${ctx}/images/fx.png"/><br>
                经营分析
            </div>
            <div>
                <img src="${ctx}/images/pj.png" /><br>
                用户评价
            </div>
            <div>
                <img src="${ctx}/images/kf.png"/><br>
                技术支持
            </div>
        </div>

        <div class="announcement">
            <img src="${ctx}/images/gg.png"></img>
            <span>平台优惠大放送....</span>
        </div>
        <div class="foods_div">
            <div class="title_div">
                代接订单
            </div>

            <c:forEach var="food" items="${pendingOrders}">

                <div class="order_ing">
                    <div class="order_l">
                        <img src="${ctx}/images/hlt.png">
                    </div>
                    <div class="order_r">
                        <img src="${ctx}/images/ts.png" />
                        <div>下单时间：
                            <fmt:parseDate value="${food.create_time}" pattern="y-M-dd'T'H:m:s" var="myParseDate"></fmt:parseDate>
                            <fmt:formatDate value="${myParseDate}"  pattern="yyyy.MM.dd HH:mm:ss"></fmt:formatDate >
<%--                            <fmt:formatDate value="${food.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>--%>
<%--                            ${food.create_time}--%>
                        </div>
<%--                        <div>顾客位置：<span>堂食:10号桌</span></div>--%>
                        <div>订单编号：<span>NO:${food.order_no}</span></div>
                        <div class="ckxq">查看详情&gt;&gt;</div>
                        <div class="caozuo">
                            <button>取消订单</button>
                            <button onclick="takeOrder(${food.id})">接单</button>
                        </div>
                    </div>
                </div>
            </c:forEach>


        </div>



    </div>
    <footer id="tabbar" class="tabbar">
        <div class="active">
            <img src="${ctx}/images/bar/home_active.png" /><br>
            首页
        </div>
        <div>
            <img src="${ctx}/images/bar/order.png" /><br>
            订单
        </div>
        <div>
            <img src="${ctx}/images/bar/setting.png" /><br>
            管理
        </div>
        <div>
            <img src="${ctx}/images/bar/about.png" /><br>
            我的
        </div>
    </footer>
</body>

</html>