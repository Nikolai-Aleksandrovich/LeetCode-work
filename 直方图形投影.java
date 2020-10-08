package com.itranswarp.sample;

public class Solution {
    public int projectionArea(int[][] grid) {
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            int bestRow = 0;
            int bestCol = 0;
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    sum++;
                }
                bestRow = Math.max(bestRow,grid[i][j]);
                bestCol = Math.max(bestCol,grid[j][i]);
            }
            sum+=bestCol+bestRow;
        }
        return sum;
    }
}
