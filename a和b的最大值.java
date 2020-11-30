package com.itranswarp.sample;

public class Solution {
    public int maximum(int a, int b) {
        long x = (long) a -(long)b;
        int k = (int)(x>>>63);
        return k*b-(-1+k)*a;

        /**long a1 =(long) a;
        long b1 =(long) b;
        int ans=(int)(Math.abs(a-b)+a+b)/2;
        return ans;//这方法不太行
        */
        //位运算的解法没看懂




    }
}
