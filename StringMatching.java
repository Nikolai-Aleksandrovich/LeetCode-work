package com.itranswarp.sample;

import java.util.ArrayList;
import java.util.List;

public class StringMatching {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String s1:words){
            sb.append(s1).append(",");
        }
        for (String s1:words){
            if(sb.indexOf(s1)!=sb.lastIndexOf(s1)){
                list.add(s1);
            }
        }
        return list;
    }
}
