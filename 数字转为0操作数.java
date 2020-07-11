package com.pratiace.fristpackage;
//给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
public class Solution {
    private int count = 0;
    public int numberOfSteps (int num) {
        if (num != 0) {
            count++;
            if ((num & 1) != 0) {
                numberOfSteps(num & -2);
            } else {
                numberOfSteps(num >> 1);
            }
        }
        return count;

        //假设不使用四则运算符, 利用位运算(迭代 & 递归)
//        int count = 0;
//        while (num != 0){
//            //迭代
//            count++;
//            num = (num & 1)==1? num&2 : num>>1;
//        }
//        return count;

        //if-then-else
        //暴力解法
//        int nextnum = 0;
//        int count = 0;
//        while(num>0) {
//            if (num % 2 == 0) {
//                num = num / 2;
//                count++;
//
//            } else {
//                num = num - 1;
//                count++;
//            }
//        }
//        return count;
//
//        }

    }
}
