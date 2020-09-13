package com.itranswarp.sample;

import java.util.*;

public class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int num:nums){
            if(hashmap.containsKey(num)){
                hashmap.put(num,2);
            }else {
                hashmap.put(num,1);
            }
        }
        for (int num:nums){
            if(hashmap.get(num)==1){
                return num;
            }
        }
        return 0;
        /**Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            sum+=num;
            set.add(num);
        }
        int total = 0;
        for (Integer element:set){
            total+=element;
        }
        return 2*total-sum;
         */


        /**Set<Integer> set = new HashSet<>();//用了set放入，检查set中是否存在
         * 如果存在就删除，最后一定只剩最后一个单独元素
        for(int i=0;i<nums.length;i++){
            if(set.add(nums[i])){

            }else {
                set.remove(nums[i]);
            }
        }
        for(Integer elements:set){
            return elements;
        }
        return 0;
         */
        /**int ans =0;
        for (int elements:nums){
            ans = elements^ans;
        }
        return ans;
         */
    }
}
