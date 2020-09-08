package com.itranswarp.sample;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] diStringMatch(String S) {
        int hi = S.length();//题目的方法，设置一个HI 一个LO两个指针，不断指向高值和低值
        int lo = 0;
        int[] ans = new int[S.length()+1];
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='I'){
                ans[i]=lo;
                lo++;
            }else {
                ans[i]=hi;
                hi--;
            }
        }
        if(S.charAt(S.length()-1)=='I'){
            ans[S.length()]=hi;
        }else{
            ans[S.length()]=lo;
        }
        return ans;

        /**
        int count = 0;//不清楚哪里出了问题，但是思路应该没错
        int[] ans = new int[S.length()];
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='D') {
                count++;
            }
        }
        ans[0] = count;
        for(int i=0,j=0,k=0;i<S.length();i++){
            if(S.charAt(i)=='D'){
                j++;
                ans[i+1]=count-j;

            }else{
                k++;
                ans[i+1]=count+k;

            }
        }
        return ans;
         */
    }
}
