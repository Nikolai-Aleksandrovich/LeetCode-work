package com.itranswarp.sample;

public class Solution {
    public int[] exchange(int[] nums) {
        int front =0;
        int end = nums.length-1;
        while (front<end){
            int temp;
            if(nums[front]%2==0){
                temp=nums[front];
                while (nums[end]%2==0){
                    end--;
                    if(end==front){
                        return nums;
                    }
                }
                nums[front]=nums[end];
                nums[end]=temp;
            }
            front++;

        }
        return nums;
    }
}
