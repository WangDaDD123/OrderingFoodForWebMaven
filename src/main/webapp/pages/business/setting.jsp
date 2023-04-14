<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<% request.setAttribute("url", "http://localhost:8080/OrderingFoodForWebMaven");%>
<html lang="zh_CN">
<script src="${ctx}/js/jumpMenu.js"></script>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>菜品维护</title>
    <style>
        @import url(../../css/business/setting.css);
    </style>
</head>
<body>
    <div class="title">商品管理</div>
    <div class="body_box">
        <div class="top_menu">
            <div class="active_menu">全部<span>20</span></div>
            <div >已下架<span>5</span></div>
            <div >折扣<span>15</span></div>
            <div >已售罄<span>10</span></div>
            <div class="other_menu">...</div>
        </div>


        <div class="item_box">
            <div class="item_l">
                <div>
                    门店福利
                </div>
                <div class="active_group">
                    优惠套餐
                </div>
                <div>
                    热门单品
                </div>
            </div>

            <div class="item_r">
                <div class="item_r_row">
                    <div>
                        <img src="../../images/hlt.png"/>
                    </div>
                    <div>
                        <div>正宗逍遥镇胡辣汤</div>
                        <div class="item_info">&gt;</div>
                        <div>
                            <span>月销100</span>
                            <span>库存无限</span>
                        </div>
                        <div>
                            <span class="item_new_price">￥16.9</span>
                            <del class="item_old_price">
                               <span>￥</span>36.5 
                            </del>
                            <span class="item_discount">5.1折</span>
                        </div>
                        <div>
                            <button>促销</button>
                            <button>库存</button>
                            <button>下架</button>
                        </div>
                    </div>
                </div>
                
                <div class="item_r_row">
                    <div>
                        <img src="../../images/hlt.png"/>
                    </div>
                    <div>
                        <div>正宗逍遥镇胡辣汤</div>
                        <div class="item_info">&gt;</div>
                        <div>
                            <span>月销100</span>
                            <span>库存无限</span>
                        </div>
                        <div>
                            <span class="item_new_price">￥16.9</span>
                            <del class="item_old_price">
                               <span>￥</span>36.5 
                            </del>
                            <span class="item_discount">5.1折</span>
                        </div>
                        <div>
                            <button>促销</button>
                            <button>库存</button>
                            <button>下架</button>
                        </div>
                    </div>
                </div>


                
            </div>
        </div>



    </div>


      <!-- 底部菜单 -->
      <footer  id="tabbar" class="tabbar">
        <div >
            <img src="../../images/bar/home.png" /><br>
            首页
        </div>
        <div >
            <img src="../../images/bar/order.png" /><br>
            订单
        </div>
        <div class="active">
            <img src="../../images/bar/setting_active.png" /><br>
            管理
        </div>
        <div>
            <img src="../../images/bar/about.png" /><br>
            我的
        </div>
    </footer>
</body>
</html>