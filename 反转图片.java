package com.itranswarp.sample;

public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int colnum = A[0].length;
        for(int j = 0;j<A.length;j++){
            for(int i =0;i<(colnum+1)/2;i++){
                int temp = A[j][i]^1;
                A[j][i] = A[j][colnum-1-i]^1;
                A[j][colnum-1-i] = temp;


            }
        }



        return A;
    }
}
