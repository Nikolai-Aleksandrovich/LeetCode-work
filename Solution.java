package com.itranswarp.sample;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==nums1[i]){
                    for (int k=j;k<nums2.length;k++){
                        if(nums2[k]>nums1[i]){
                            ans[i]=nums2[k];
                            break;
                        }
                    }
                    break;
                }
                if(nums2[j]>nums1[i]){
                    ans[i]=nums2[i+1];
                }else {
                    ans[i]=-1;
                }
            }
        }
        return ans;
    }

}
