package com.itranswarp.sample;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String s:emails){
            boolean passmid = false;
            StringBuilder sb = new StringBuilder("");
            char[] temp = s.toCharArray();
            for (int i=0;i<temp.length;i++){
                if(temp[i]=='@'){
                    passmid=true;
                }
                if(passmid){
                    sb.append(temp[i]);
                }else {
                    if(temp[i]=='.'){
                    }else if(temp[i]=='+'){
                        while (temp[i]!='@'){
                            i++;
                        }
                        i-=1;
                    }else {
                        sb.append(temp[i]);
                    }
                }
            }
            set.add(sb.toString());
        }
        return set.size();

    }
}
