package com.itranswarp.sample;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int element:nums){
            if(set.contains(element)){
                return element;
            }else {
                set.add(element);
            }
        }
        return 0;
    }
}
