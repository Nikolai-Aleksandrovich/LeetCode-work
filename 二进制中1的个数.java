package com.itranswarp.sample;

public class Solution {
    public int hammingWeight(int n) {
        long x = (long) n;
        int count = 0;
        while(x!=0){
            x=x&x-1;
            count++;
        }
        return count;

    }
}
