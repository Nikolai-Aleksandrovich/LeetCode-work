package com.itranswarp.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[][] findContinuousSequence(int target) {
        int first=1;
        int second=2;
        List<int[]> ans = new ArrayList<>();
        helper(first,second,target,ans);
        return ans.toArray(new int[ans.size()][]);
    }
    private void helper(int start,int second,int target,List<int[]> ans){
        if(start>=second){
            return;
        }
        int cur = (start+second)*(second-start+1)/2;
        int mid = (target+1)/2;
        while(start<second||second<mid) {
            if (cur < target) {
                second++;
            }
            if (cur > target) {
                start++;
            }
            if (cur == target) {
                int[] sortofans = new int[second-start+1];
                for (int i=start;i<=second;i++){

                    sortofans[i-start]=i;
                }
                ans.add(sortofans);
            }
        }
        helper(start,second,target,ans);
    }
}
