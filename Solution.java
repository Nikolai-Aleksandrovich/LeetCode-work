package com.itranswarp.sample;

import java.lang.reflect.Array;

public class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        helper(start,end,s);

        /**for (int i=0;i<s.length/2;i++){迭代很简单，我看答案还能递归，我想想
            char temp;
            temp = s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;

        }
         */
    }
    public void helper(int start,int end,char[] s){
        if(start>=end){
            return;
        }
        char temp = s[start];
        s[start]=s[end];
        s[end]=temp;
        start++;
        end--;
        helper(start,end,s);

    }

}
