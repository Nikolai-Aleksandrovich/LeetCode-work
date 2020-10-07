package com.itranswarp.sample;

class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] map = new int[501];
        for(int num : arr) map[num]++;
        for(int i=500; i>0; i--)
            if(i==map[i])
                return i;

        return -1;
    }
}