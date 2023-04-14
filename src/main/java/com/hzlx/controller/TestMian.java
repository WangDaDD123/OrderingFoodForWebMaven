package com.hzlx.controller;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/4/7 11:18
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class TestMian {
    //这是一个main方法，这是程序的入口
    public static void main(String[] args) {
        String s1 = "http://localhost:8080/OrderingFoodForWeb/register.do";
        String s2 = "/OrderingFoodForWeb/register.do";

        int len = s1.length() - s2.length();
        int i = s1.indexOf("/", len+1);
        System.out.println(i);
        System.out.println("http://localhost:8080/OrderingFoodForWeb/".length());
        System.out.println(len);

        System.out.println(s1.substring(0, i));

    }
}
