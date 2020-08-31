package com.itranswarp.sample;
//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
//
//请你统计并返回 grid 中 负数 的数目。
public class Solution {
    public int countNegatives(int[][] grid) {
        int rowNum = grid.length;
        int colNUm = grid[0].length;
        int count = 0;
        for(int i=0;i< rowNum;i++){
            for(int j = 0;j<colNUm;j++){
                if(grid[i][j]<0){
                    count += (colNUm-j)*(rowNum-i);
                    colNUm = colNUm - (colNUm-j);


                }
            }
        }
        return count;

    }
}
