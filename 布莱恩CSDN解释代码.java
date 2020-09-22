package com.itranswarp.sample;

public class Example {
    public static void main(String[] args) {
        //布莱恩克尼根算法举例：
        int ans = 0;
        int number = 50;
        while (number != 0) {
            //每次循环，number和number-1进行and运算，并更新number
            //每次number都会在and运算中去掉最低位的1
            //直到最后一次运算，number最高位的1也被去掉，number的值为0
            System.out.println(Integer.toBinaryString(number));
            (number) = (number - 1) & (number);
            ans++;
        }
        System.out.println(ans);
    }
}



