package com.itranswarp.sample;

import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {

        Integer mainNum = null;
        int count = 0;
        for (int element:nums){
            if(count==0){
                mainNum=element;
            }
            if(element==mainNum){
                count++;
            }else {
                count--;
            }

        }
        return mainNum;
    }
}
