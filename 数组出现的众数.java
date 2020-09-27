package com.itranswarp.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0];//投票法
        int calculate = 0;
        for (int i =0;i<nums.length;i++){
            if(nums[i]==ans){
                calculate++;
            }else {
                calculate--;
            }
            if(calculate==0){
                ans=nums[i+1];
            }
        }
        return ans;
        /**Arrays.sort(nums);//这是直接取数组中断数字
        return nums[nums.length/2];
         */
        /**HashMap<Integer,Integer> hashMap = new HashMap<>();//这是哈希表统计
        for (int element:nums){
            if(hashMap.containsKey(element)){
                hashMap.put(element,hashMap.get(element)+1);
            }else {
                hashMap.put(element,1);
            }
        }
        int max = 0;
        for (Integer i:hashMap.keySet()){
            if(hashMap.get(i)*2>nums.length){
                return i;

            }

        }
        return 0;
         */

    }
}
