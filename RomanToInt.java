package com.itranswarp.sample;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
        char[] newArray = s.toCharArray();
        int ans = hashMap.get(newArray[newArray.length-1]);
        for (int i=s.length()-1;i>0;i--){
            if(hashMap.get(newArray[i])>hashMap.get(newArray[i-1])){
                ans-=hashMap.get(newArray[i-1]);
            }else {
                ans+=hashMap.get(newArray[i-1]);
            }
        }
        return ans;

    }
}
