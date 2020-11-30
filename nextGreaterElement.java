package com.itranswarp.sample;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0;i<nums2.length;i++){
            while(!stack.isEmpty()&&nums2[i]>stack.peek()) {
                hashMap.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
            }
        while (!stack.isEmpty()){
            hashMap.put(stack.pop(),-1 );
        }
        int[] res = new int[nums1.length];
        for (int i = 0;i< nums1.length;i++){
            res[i]=hashMap.get(nums1[i]);
        }
        return res;
    }
}
