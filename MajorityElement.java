package com.itranswarp.sample;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int mainElement = nums[0];
        int vote = 0;
        for (int element:nums){
            if(element!=mainElement){
                if(vote>0){
                    vote--;
                }else {
                    vote++;
                    mainElement=element;
                }
            }else {
                vote++;
            }
        }
        if(vote>0){
            int count =0;
            for(int element:nums){
                if(element==mainElement){
                    count++;
                }
                if(count> nums.length/2){
                    return mainElement;
                }
            }

        }
        return -1;
    }
}
