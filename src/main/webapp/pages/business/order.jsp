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
    <title>订单列表</title>
    <style>
        @import url(${ctx}/css/business/order.css);
    </style>
    <script src="${ctx}/js/jumpMenu.js"></script>

</head>
<body>
    <div class="bgc_box"></div>
    <div class="body_dox">
        <h1 class="title_h1">订单列表</h1>

        <div class="content_box">
            <div class="top_menu">
                <div class="active_menu">全部订单</div>
                <div>待处理</div>
                <div>已完成</div>
            </div>
            
            <div class="zw">
                <!-- 这个DIV用于占位 没有别的特殊意义 -->
            </div>

            <div class="order_item_box">
                <div class="order_l">
                      <img src="${ctx}/images/hlt.png" />
                </div>
                <div class="order_r">
                    <img src="${ctx}/images/wm.png" />
                    <div class="orderNo">订单编号：NO202304082010</div>
                    <div>下单时间：2023-04-08 20:12:43</div>
                    <div>查看详情</div>
                    <div class="caozuo">
                        <button>取消订单</button>
                        <button>取消订单</button>
                    </div>
                </div>
            </div>

            <div class="order_item_box">
                <div class="order_l">
                    <img src="${ctx}/images/hlt.png" />
                </div>
                <div class="order_r">
                    <img src="${ctx}/images/wm.png" />
                    <div class="orderNo">订单编号：NO202304082010</div>
                    <div>下单时间：2023-04-08 20:12:43</div>
                    <div>查看详情</div>
                    <div class="caozuo">
                        <button>取消订单</button>
                        <button>取消订单</button>
                    </div>
                </div>
            </div>
            
        </div>
    </div>


    <!-- 底部菜单 -->
    <footer  id="tabbar" class="tabbar">
        <div >
            <img src="${ctx}/images/bar/home.png" /><br>
            首页
        </div>
        <div class="active">
            <img src="${ctx}/images/bar/order_active.png" /><br>
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