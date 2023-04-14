window.onload=()=>{
    //获取底部菜单最大的盒子元素
    var tabbar = document.getElementById("tabbar");
    //获取所有的菜单div
    var divs = tabbar.querySelectorAll("div");
    for (let i = 0; i < divs.length; i++) {
        divs[i].onclick=function (){
            let url="";
            switch (i){
                case 0:
                    url="/OrderingFoodForWeb/businessHome.do";
                    break;
                case 1:
                    url="/OrderingFoodForWeb/pages/business/order.jsp"
                    break;
                case 2:
                    url="/OrderingFoodForWeb/pages/business/setting.jsp"
                    break;
                case 3:
                    url="/OrderingFoodForWeb/pages/business/about.jsp"
                    break;
                default:
                    url="/OrderingFoodForWeb/businessHome.do";
                    break;
            }
            location.href=url;
        }
    }
}