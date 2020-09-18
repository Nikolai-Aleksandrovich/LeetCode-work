package com.itranswarp.sample;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;

public class Solution {
    public int minCostToMoveChips(int[] position) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        int count = 0;
        for(int element:position){
            if(hashmap.containsKey(element)){
                hashmap.put(element,hashmap.get(element)+1);
            }else {
                hashmap.put(element,1);
            }
        }
        Collection<Integer> c = hashmap.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        stream(obj).max()
        for(int elements:position){
            if((elements-obj)%2==1){
                count++;
            }
        }
        return count;
    }
}
