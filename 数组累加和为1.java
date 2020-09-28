package com.itranswarp.sample;

public class Solution {
    public int minStartValue(int[] nums) {
        int ans = 0;
        int totalValue = 0;
        for (int element:nums){
            totalValue = totalValue+element;
            while (totalValue<1){
                ans++;
                totalValue++;
            }
        }
        return ans;
    }
}
