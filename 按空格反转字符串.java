package com.itranswarp.sample;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int finalSpace = 0;
        for(int i =0,j=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                for(int k=i-1;k>=j;k--){
                    sb.append(s.charAt(k));
                }
                j=i+1;
                sb.append(' ');
            }
            finalSpace = j;
        }
        for(int i=s.length()-1;i>=finalSpace;i--){
            sb.append(s.charAt(i));
        }

        return sb.toString();

    }
}
