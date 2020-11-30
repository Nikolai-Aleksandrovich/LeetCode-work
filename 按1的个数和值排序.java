package com.itranswarp.sample;

import java.util.Arrays;

public class Solution {
    public int[] sortByBits(int[] arr) {
        int[] ans = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=Integer.bitCount(arr[i])*100000+arr[i];
        }
        Arrays.sort(ans);
        for (int i=0;i<arr.length;i++){
            ans[i]=ans[i]%100000;
        }
        return ans;


    }
}
