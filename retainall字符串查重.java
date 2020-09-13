package com.itranswarp.sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int element:nums1){
            set1.add(element);
        }
        for (int element:nums2){
            set2.add(element);
        }
        set1.retainAll(set2);//java retainAll函数
        int[] output =new int[set1.size()];
        int idx =0;
        for(int s:set1){
            output[idx++]=s;
        }
        return output;
        /**def intersection(self, nums1, nums2):python的and操作也可以返回
         """
         :type nums1: List[int]
         :type nums2: List[int]
         :rtype: List[int]
         """
         set1 = set(nums1)
         set2 = set(nums2)
         return list(set2 & set1)
        */
        /**HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int element:nums1){
            set1.add(element);
        }
        for (int element:nums2){
            set2.add(element);
        }
        if(set1.size()>set2.size()){
            return set_intersection(set2,set1);
        }else {
            return set_intersection(set1,set2);
        }


    }
    private int[] set_intersection(HashSet<Integer> set1,HashSet<Integer> set2){
        int[] ans = new int[set1.size()];
        int index = 0;
        for(int element:set1){
            if(set2.contains(element)){
                ans[index]=element;
                index++;
            }
        }
        return Arrays.copyOf(ans,index);
         */
    }
}
