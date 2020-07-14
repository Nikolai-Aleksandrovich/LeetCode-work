package com.pratiace.fristpackage;
//给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
//
//请你计算并返回该式的最大值。
//

public class Solution {
    public int maxProduct(int[] nums) {
        int biggest = 0;
        int secbiggest = 0;
        int biggestindex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (biggest < nums[i]) {
                biggest = nums[i];
                biggestindex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {

            if (i == biggestindex) {
            } else {
                if (secbiggest < nums[i]) {
                    secbiggest = nums[i];
                }
            }

        }
        return (biggest-1)*(secbiggest-1);
    }

}
//break直接终止循环，continue跳过这次循环
