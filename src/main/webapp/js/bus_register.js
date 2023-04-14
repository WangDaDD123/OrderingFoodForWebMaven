//XMLHttpRequest是JS中专门用来发送请求的一个工具类
var xhr = new XMLHttpRequest();
var userNameCheck=false;

function checkUserName() {
    //1.获取id为userName的input框的值
    let userNameDOM = document.getElementById("userName");
    //显示错误提示的span标签
    let userNameMsgDOM = document.getElementById("userNameMsg");
    //获取userName输入框的值
    let userNameValue = userNameDOM.value;
    //当用户名为空的时候，显示错误的提示信息 （用户名不能为空）
    if (userNameValue == "" || userNameValue == null) {
        //用js显示提示文字
        userNameMsgDOM.innerText = "用户名不能为空";
    } else {
        //userNameMsgDOM.innerText="";
        //发送一个请求到后端服务器，校验用户名是否重复  异步请求
        xhr.open("get", "http://localhost:8080/OrderingFoodForWeb/busCheckUserName.do?userName=" + userNameValue);
        xhr.onreadystatechange = callBack;
        xhr.send(null);
    }
}

//回调函数
function callBack() {
    let userNameMsgDOM = document.getElementById("userNameMsg");
    if (xhr.readyState == 4 && xhr.status == 200) {
        var responseText = xhr.responseText;
        console.log(responseText+":"+typeof responseText);
        if (responseText == -1) {
            userNameMsgDOM.innerText="用户名不能为空";
            return;
        }
        if (responseText>0){
            userNameMsgDOM.innerText="用户名已经存在!";
            return;
        }
        userNameCheck=true;//设置表单可提交
        userNameMsgDOM.innerText="";
    }
}

function subForm(){
    //对所以的输入内容做校验
    return userNameCheck;
}