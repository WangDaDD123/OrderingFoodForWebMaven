package com.hzlx.utils;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/3/31 8:54
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public class TestMain {
    //这是一个main方法，这是程序的入口
   /* public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("请输入打印的行数：");
        int count=input.nextInt();
        for (int i = count; i >0 ; i--) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j+"\t");
            }
            System.out.println();
        }
    }*/

    /**
     * 利用二重循环实现
     * 用整型变量i和j分别表示要买的公鸡数和母鸡数，则i不超过20，j不超过33。
     * 用整型变量k（3的倍数）表示雏鸡数，一共100文钱，则可以得到：5×i＋3×j＋k/3=100。
     * 一共买100只鸡，则有i＋j＋k＝100
     */
    //这是一个main方法，这是程序的入口
    public static void main(String[] args) {
        //设 公鸡的个数是i 母鸡j 
        for (int i = 0; i < 100 / 5; i++) {
            for (int j = 0; j < 33; j++) {
                int k = 100 - i - j;
                if ((5 * i + 3 * j + (k / 3) == 100) && k % 3 == 0) {
                    System.out.println("公鸡：" + i + "\t母鸡：" + j + "\t小鸡：" + k);
                }
            }
        }
    }

}
