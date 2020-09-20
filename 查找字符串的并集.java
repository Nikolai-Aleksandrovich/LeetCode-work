package com.itranswarp.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] res = new int[26];
        for (char c:A[0].toCharArray()){
            res[c-'a']++;
        }
        for (int i=0;i<A.length;i++){
            int[] temp = new int[26];
            for(int c:A[i].toCharArray()){
                temp[c-'a']++;
            }
            for (int j=0;j<26;j++){
                res[j]=Math.min(temp[j],res[j]);
            }
        }
        for (int i=0;i<26;i++){
            if(res[i]>0){
                for (int j=0;j<res[i];j++){
                    list.add((char)(i+'a')+"");
                }

            }

        }
        return list;

    }
}
