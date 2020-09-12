package com.itranswarp.sample;

import java.util.Arrays;

public class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int lo = 0;
        int hi = arr2.length-1;
        while(lo<hi){
            int mid = (hi-lo)/2+lo;
            for(int elements:arr1){
                if (elements-arr2[mid]<=d){
                    lo = mid+1;
                }else{
                    hi = mid;
                }
            }
        }
        return arr2.length-lo;
        /**int count = 0;
        boolean ifSkip = false;
        for(int element:arr1){
            for (int componants:arr2){
                if(Math.abs(element-componants)<=d){
                    ifSkip=true;
                    break;
                }
            }
            if(ifSkip){
                ifSkip=false;
            }else {
                count++;
            }
        }
        return count;
         */
    }
}
