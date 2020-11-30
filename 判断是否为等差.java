package com.itranswarp.sample;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class Solution1 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for(int i =0;i<arr.length-2;i++){
            if(arr[i+1]==arr[i]+arr[i+2]){
                return true;
            }
        }
        return false;
    }
}
