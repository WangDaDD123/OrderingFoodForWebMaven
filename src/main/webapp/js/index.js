function goLoginPage(index){
    let url;
    switch (index){
        case 1:
            url="pages/business/login.jsp";
            break;
        case 2:
            url="pages/user/login.jsp"
            break;
        case 3:
            url="pages/rider/login.jsp"
            break;
        default:
            break;
    }
    location.href=url;
}