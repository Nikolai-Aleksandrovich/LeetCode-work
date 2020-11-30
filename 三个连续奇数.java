package com.itranswarp.sample;

public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i =1;i+1<arr.length;i+=2){
            if(arr[i+1]%2==0){
                i++;
            }
            if(arr[i-1]%2!=0&&arr[i]%2!=0){
                return true;

            }
        }
        return false;

    }
}
