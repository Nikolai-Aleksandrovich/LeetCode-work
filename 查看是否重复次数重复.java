package com.itranswarp.sample;

import java.util.*;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int elements:arr){
            map.merge(elements, 1, Integer::sum);
        }
        for (Integer element:map.values()){
            if(!set.add(element)){
                return false;
            }
            
        }
        return true;

    }
}
