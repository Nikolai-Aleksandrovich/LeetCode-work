package com.itranswarp.sample;

public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int count = 0;
        for(String s:sentence.split(" ")){
            count++;
            if(s.length()>=searchWord.length()){
                if(s.indexOf(searchWord)==0){
                    return count;
                }
            }

        }
        return -1;
    }
}
