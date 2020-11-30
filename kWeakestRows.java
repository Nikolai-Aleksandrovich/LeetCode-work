package com.itranswarp.sample;

import java.util.Arrays;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] force = new int[mat.length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    force[i]++;
                }
                if(mat[i][j]==0){
                    break;
                }
            }
            force[i]=force[i]*1000+i;
        }
        Arrays.sort(force);
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=force[i]%1000;
        }
        return ans;
    }
}
