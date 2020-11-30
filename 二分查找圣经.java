package com.itranswarp.sample;

public class Solution {
    public int findMagicIndex(int[] nums) {

        return getAnswer(nums,0,nums.length-1);
        /**int ans = -1;
        for(int i=0;i< nums.length;i++){
            if(i==nums[i]){
                return i;
            }
        }
        return ans;
         */

    }
    private int getAnswer(int[] nums,int lo,int hi){
        if(lo>hi){
            return -1;
        }
        int mid = (hi-lo)/2+lo;
        int leftAnswer = getAnswer(nums,lo,mid-1);
        if(leftAnswer!=-1){
            return leftAnswer;
        }else if(nums[mid]-mid==0){
            return mid;
        }else {
            return getAnswer(nums,mid+1,hi);
        }

    }
}
