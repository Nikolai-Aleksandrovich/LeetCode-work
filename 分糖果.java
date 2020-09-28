package com.itranswarp.sample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distributeCandies(int[] candies) {
        /**Set<Integer> set = new HashSet<>();
        for(int element:candies){
            if (!set.contains(element)){
                set.add(element);
            }
        }
        return Math.min(set.size(), candies.length / 2);
         */
        /**排名靠后
         * HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int element:candies){
            if(hashMap.containsKey(element)){
                hashMap.put(element,hashMap.get(element)+1);
            }else {
                hashMap.put(element,1);
            }
        }
        int count = 0;
        for(Integer i:hashMap.keySet()){
            count++;
        }
        return Math.min(count, candies.length / 2);
         */
    }
}
