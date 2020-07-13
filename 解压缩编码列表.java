package com.pratiace.fristpackage;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] decompressRLElist(int[] nums) {
        //难点在于声明返回数组的大小;
        //为了得到返回数组的大小,首先遍历一遍数组nums,计算索引为偶数的数字之和得到返回数组的大小len;
        //声明返回数组result的大小为len;
        //再遍历一遍数组,进行解码,解码原则为---索引为奇数i的数字nums[i]重复nums[i-1]次,并依次放入返回数组result中;
        //最后返回out;

        int a = 0;

        for(int i = 0; i<nums.length; i=i+2){

            a += nums[i];
            }
        int count = 0;
        int[] result = new int[a];
        int i = 0;
        while(i <nums.length){
            for(int j = 0; j<nums[i]; j++){
                result[count] = nums[i+1];
                count+=1;
            }
            i+=2;


        }
        return result;





    }
}
