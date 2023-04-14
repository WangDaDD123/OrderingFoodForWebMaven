//接单函数
function takeOrder(orderId) {
    //发送异步请求
    $.ajax({
        url: "/OrderingFoodForWeb/takeOrder.do",//请求地址
        type: "post",//请求方式
        data:{
            orderId:orderId
        },//请求参数
        success:function (resp){
            //成功的回调
            console.log(resp);
            let res=JSON.parse(resp);
            if (res.code==200){
                //页面刷新
                location.reload();
            }else {
                alert(res.message)
            }
        },
        error:function (){
            //失败的回调
            alert("服务器异常！")
        }
    })




}