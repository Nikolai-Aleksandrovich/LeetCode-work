package com.itranswarp.sample;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        /**
        //尝试group存储
        Map<Integer,Integer> group = new HashMap<>();
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(!group.containsKey(i-j)){
                    group.put(i-j,matrix[i][j]);
                }else {
                    if(group.get(i-j)!=matrix[i][j]){
                        return false;
                    }
                }
            }
        }

        return true;
         */
        /**
         * //暴力法
        for(int i = 0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(i+1<matrix.length&&j+1<matrix[0].length){
                    if(matrix[i+1][j+1]!=matrix[i][j]){
                        return false;
                    }
                }
            }
        }
        return true;
         */
    }
}
