package com.itranswarp.sample;

import java.util.Arrays;

public class Solution {
    public int countLargestGroup(int n) {
        int max = 0;
        int[] count = new int[n+1];
        for (int i=1;i<n+1;i++) {
            count[i / 10 + i % 10]++;
        }
        for (int element:count){
            if(element>max){
                max=element;
            }
        }
        int ans=0;
        for (int element:count){
            if(element==max){
                ans++;
            }
        }
        return ans;

    }
}
