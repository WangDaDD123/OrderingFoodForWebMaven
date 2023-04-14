<%--
  Created by IntelliJ IDEA.
  User: muyan
  Date: 2023/4/11
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<html>
<head>
    <title>三级联动</title>
    <script src="${ctx}/js/jquery.min.js"></script>
    <script>
        window.onload = function () {
            //页面加载完成之后 把省份select 动态绑定上数据
            var pro = document.getElementById("province");
            //发送异步请求拿数据
            $.ajax({
                url: "${ctx}/sysRegion.do",
                type: "get",
                data: {
                    parentId: -1
                },
                success: function (resp) {
                    var parse = JSON.parse(resp);
                    if (parse.code == 200) {
                        //数据就拿到了
                        //创建option元素
                        let addressList = parse.data;
                        for (let i = 0; i < addressList.length; i++) {
                            var optionElement = document.createElement("option");
                            optionElement.value =addressList[i].id;
                            optionElement.innerText=addressList[i].name;
                            pro.appendChild(optionElement);
                        }
                    } else {
                        //输出 服务器返回的错误信息
                        alert(parse.message)
                    }
                },
                error: function () {
                    alert("网络通讯异常!请稍后再试")
                }
            })
        }

        function checkPro(value){

            var city = document.getElementById("city");
            let size=city.childNodes.length;
            for (let i = size; i >=0 ; i--) {
                 // 循环删除area下的子元素
                city.remove(city.childNodes)
            }
            //发送异步请求拿数据
            $.ajax({
                url: "${ctx}/sysRegion.do",
                type: "get",
                data: {
                    parentId: value
                },
                success: function (resp) {
                    var parse = JSON.parse(resp);
                    if (parse.code == 200) {
                        //数据就拿到了
                        //创建option元素
                        let addressList = parse.data;

                        for (let i = 0; i < addressList.length; i++) {
                            var optionElement = document.createElement("option");
                            optionElement.value =addressList[i].id;
                            optionElement.innerText=addressList[i].name;
                            city.appendChild(optionElement);
                        }
                    } else {
                        //输出 服务器返回的错误信息
                        alert(parse.message)
                    }
                },
                error: function () {
                    alert("网络通讯异常!请稍后再试")
                }
            })
        }
        function checkCity(value){

            var area = document.getElementById("area");
            //获取area的子元素
            let size=area.childNodes.length
            for (let i = size; i >=0; i--) {
                //循环删除area下的子元素
                area.remove(area.childNodes)
            }
            //发送异步请求拿数据
            $.ajax({
                url: "${ctx}/sysRegion.do",
                type: "get",
                data: {
                    parentId: value
                },
                success: function (resp) {
                    var parse = JSON.parse(resp);
                    if (parse.code == 200) {
                        //数据就拿到了
                        //创建option元素
                        let addressList = parse.data;

                        for (let i = 0; i < addressList.length; i++) {
                            var optionElement = document.createElement("option");
                            optionElement.value =addressList[i].id;
                            optionElement.innerText=addressList[i].name;
                            area.appendChild(optionElement);
                        }
                    } else {
                        //输出 服务器返回的错误信息
                        alert(parse.message)
                    }
                },
                error: function () {
                    alert("网络通讯异常!请稍后再试")
                }
            })
        }
    </script>
</head>
<body>
省：<select id="province" onchange="checkPro(this.value)">
    <option>请选择</option>
</select>
市：<select id="city"  onchange="checkCity(this.value)">
    <option>请选择</option></select>
区/县:<select id="area">
    <option>请选择</option></select>
</body>
</html>

