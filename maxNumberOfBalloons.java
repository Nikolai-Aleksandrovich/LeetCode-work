package com.itranswarp.sample;

import java.util.HashMap;
import java.util.Set;

public class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] balloon = new char[]{'b','a','l','l','o','n'};
        for (char c:balloon){
            hashMap.put(c,0);
        }
        for(char c:text.toCharArray()){
            if(hashMap.containsKey(c)){
                hashMap.put(c,hashMap.get(c)+1);
            }
        }
        int ans = text.length();
        for (char key:hashMap.keySet()){
            if(ans>hashMap.get(key)){
                ans=hashMap.get(key);
            }
        }
        return ans;

    }
}
