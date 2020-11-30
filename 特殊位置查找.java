package com.itranswarp.sample;

public class Solution {
    int ans = 0;
    public int numSpecial(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if((helper1(mat,i,i+1,j)&&helper1(mat,i,i-1,j)&&helper2(mat,i,i,j+1)&&helper2(mat,i,i,j-1))==true){
                        ans++;

                    }
                }
            }
        }
        return ans;
    }
    private boolean helper1(int[][] mat,int i,int index1,int j){
        if(index1<0||index1>mat.length-1){
            return true;
        }
        int count = -1;
        if(mat[index1][j]==1){
            return false;
        }
        if(index1>i){
            return helper1(mat,i,index1+1,j);
        }else {
            return helper1(mat,i,index1-1,j);
        }


        /**
         * //设置两个数组，一个存储列中1的数量，一个存储行中1的数量
        int[] rowCount = new int[mat.length];
        int[] colCount = new int[mat[0].length];
        for(int i=0;i<rowCount.length;i++){
            for (int j=0;j<colCount.length;j++){
                if(mat[i][j]==1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<rowCount.length;i++){
            for (int j=0;j<colCount.length;j++)
            if(mat[i][j]==1&&rowCount[i]==1&&colCount[j]==1){
                ans++;
            }
        }
        return ans;
        */
    }
    private boolean helper2(int[][] mat,int j,int i,int index2){
        if(index2<0||index2>mat[0].length-1){
            return true;
        }
        if(mat[i][index2]==1){
            return false;
        }
        if(index2>j){
            return helper1(mat,j,i,index2+1);
        }else {
            return helper1(mat,j,i,index2-1);
        }}
}
