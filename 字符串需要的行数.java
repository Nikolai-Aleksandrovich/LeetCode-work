package com.itranswarp.sample;

public class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int line = 1;
        int width = 0;
        for (char c:S.toCharArray() ){
            int w = widths[c-'a'];
            width+=w;
            if(width>100){
                line++;
                width=w;
            }
        }
        return  new int[]{line,width};
    }

}
