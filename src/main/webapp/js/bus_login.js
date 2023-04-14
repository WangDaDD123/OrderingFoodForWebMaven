function login() {
    //输入的用户名  输入的密码
    var userName = $("#userName").val();
    var pwd = $("#pwd").val();
    console.log(userName)
    $.ajax({
        url: "http://localhost:8080/OrderingFoodForWeb/busLogin.do",
        type: "post",
        data: '{"userName":'+userName+',"pwd":'+pwd+'}',
        success: function (res) {
            //成功的回调

        },
        error: function () {

        }
    })
}

var str='{"name":"123","pwd":123}';
var parse = JSON.parse(str);
console.log(person.name);


var person={
    name:"张三",
    age:18,
    sleep:function (){
        console.log("睡觉了");
    }
}