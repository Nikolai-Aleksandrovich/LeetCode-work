package com.itranswarp.sample;
//给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
//
//另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
//
//你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
//
//请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix

public class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] rowCount = new int[n];
        int[] colCount = new int[m];
        for(int[] indice:indices){
            rowCount[indice[0]]+=1;
            colCount[indice[1]]+=1;
            rowCount[indice[0]]%=2;
            colCount[indice[1]]%=2;
        }
        int rowNum = 0;
        int colNum = 0;
        for(int num:rowCount){
            if(num==1){
                rowNum++;
            }
        }
        for (int num:colCount){
            if (num ==1){
                colNum++;
            }
        }
        return n*colNum+m*rowNum-2*colNum*rowNum;

        /**暴力遍历法
        int[][] pool = new int[n][m];
        for(int[] indice:indices){
            for(int j =0;j<n;j++){
                pool[j][indice[1]]+=1;
            }
            for(int i=0;i<m;i++){
                pool[indice[0]][i]+=1;
            }
        }
        int count = 0;
            for (int[] row:pool){
                for (int col :row){
                    if(col%2!=0){
                        count++;
                    }
                }
            }*/




    }
}
