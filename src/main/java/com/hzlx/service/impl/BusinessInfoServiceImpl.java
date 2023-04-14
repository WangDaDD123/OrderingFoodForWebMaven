package com.hzlx.service.impl;

import com.hzlx.dao.BusinessInfoDao;
import com.hzlx.dao.OrderInfoDao;
import com.hzlx.dao.impl.BusinessInfoDaoImpl;
import com.hzlx.dao.impl.OrderInfoDaoImpl;
import com.hzlx.entity.BusinessInfo;
import com.hzlx.service.BusinessInfoService;
import com.hzlx.utils.MD5Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/4/5 10:51
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class BusinessInfoServiceImpl implements BusinessInfoService {
    //Dao层
    private BusinessInfoDao businessInfoDao = new BusinessInfoDaoImpl();
    private OrderInfoDao orderInfoDao=new OrderInfoDaoImpl();

    @Override
    public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //设置请求编码格式为 UTF-8
        request.setCharacterEncoding("UTF-8");
        //获取请求中的数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        //密码加密
//        String pwdSalt = MD5Utils.encryptMD5AndSalt(MD5Utils.encryptMD5(pwd), "吃了喵");

//        String pwdSalt = MD5Utils.encryptMD5AndSalt(MD5Utils.encryptMD5(pwd), "吃了喵");
        //调用service中的登录方法
        BusinessInfo businessInfo = businessInfoDao.selectBusinessInfoByUserNameAndPwd(userName, pwd);

        if (null != businessInfo) {
            //把登录成功的商家信息放到session作用域中
            request.getSession().setAttribute("businessInfo", businessInfo);
            //登录成功转发到home对应的servlet去跳转home.jsp
            return "/businessHome.do";
        } else {
            //登录失败？转发到login.jsp
            return "/pages/business/login.jsp";
        }
    }

    @Override
    public BusinessInfo login(String userName, String pwd) {
        //处理pwd  加密
        String pwdSalt = MD5Utils.encryptMD5AndSalt(MD5Utils.encryptMD5(pwd), "吃了喵");
        //dao根据用户名和密码查询 商家对象 如果数据库里有  则返回对应的对象 如果没有 则返回null
        BusinessInfo businessInfo = businessInfoDao.selectBusinessInfoByUserNameAndPwd(userName, pwdSalt);

        return businessInfo;
    }

    @Override
    public int checkUserName(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //设置请求编码格式为 UTF-8
        request.setCharacterEncoding("UTF-8");
        //获取请求参数
        String userName = request.getParameter("userName");
        //判断参数是否为空
        if (userName.isEmpty()) {
            //如果为空，返回-1 标识校验不通过
            return -1;
        }
        //根据用户名查询数据库，看是否用重名的 如果有 返回查到的那个数字
        return businessInfoDao.countBusinessInfoByUserName(userName);
    }

    @Override
    public String register(HttpServletRequest request) {
        //设置请求的编码
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        //获取请求中的参数
        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        //密码加盐
        String pwd = MD5Utils.encryptMD5AndSalt(MD5Utils.encryptMD5(password), "吃了喵");
        //创建一个商家的对象 把接收到的数据 封装到这个对象中
        BusinessInfo businessInfo = new BusinessInfo();
        businessInfo.setName(name);
        businessInfo.setUserName(userName);
        businessInfo.setPassword(pwd);
        businessInfo.setAddress(address);
        businessInfo.setTel(tel);

        int insert = businessInfoDao.insert(businessInfo);

        return insert > 0 ? "/pages/business/login.jsp" : "/pages/business/register.jsp";
    }

    @Override
    public String goHome(HttpServletRequest request) {
        //从session中获取商家对象（当前登录的是哪个商家）
        BusinessInfo businessInfo = (BusinessInfo) request.getSession().getAttribute("businessInfo");
        //计算预计收入
        BigDecimal total_money = orderInfoDao.getExpectedIncome(businessInfo.getId());
        //待处理订单列表
        List<Map<String, Object>> pendingOrders = orderInfoDao.getPendingOrderList(businessInfo.getId());
        //待处理订单数
        Long pendingNum = orderInfoDao.Pending(businessInfo.getId());
        //往request作用域中存放数据
        request.setAttribute("totalMoney", total_money);//预计收入
        request.setAttribute("pendingOrders", pendingOrders);//待处理订单列表
        request.setAttribute("pendingNum", pendingNum);//待处理订单数
        return "/pages/business/home.jsp";
    }
}
