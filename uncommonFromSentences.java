package com.itranswarp.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> hashMap = new HashMap<>();
        for(String word:A.split(" ")){
            hashMap.put(word,hashMap.getOrDefault(word,0)+1);
        }
        for (String word:B.split(" ")){
            hashMap.put(word,hashMap.getOrDefault(word,0)+1);
        }
        List<String> list = new ArrayList<>();
        for (String key:hashMap.keySet()){
            if(hashMap.get(key)==1){
                list.add(key);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
