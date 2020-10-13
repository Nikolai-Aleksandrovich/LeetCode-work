package com.itranswarp.sample;

public class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans^=i;
            ans^=nums[i];
        }
        ans^=nums.length;
        return ans;
    }
}
