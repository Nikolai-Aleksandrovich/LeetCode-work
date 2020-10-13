package com.itranswarp.sample;

public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length*nums[0].length!=r*c){
            return nums;
        }
        int[][] ans = new int[r][c];
        int rows = 0,cols = 0;
        for(int i=0;i< nums.length;i++){
            for (int j=0;j<nums[0].length;j++){
                ans[rows][cols]=nums[i][j];
                cols++;
                if(cols==c){
                    rows++;
                    cols=0;
                }

            }
        }
        return ans;


    }
}
