package com.itranswarp.sample;

import java.util.Arrays;

class Solution {
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);


        if(A[A.length-1]-A[0]<2*K){
            return 0;
        }else{
            A[0]=A[0]+K;
            A[A.length-1]=A[A.length-1]-K;
            for(int i=1;i<A.length-1;i++){
                if(A[i]<A[0]){
                    A[i]=A[0];
                }
                if(A[i]>A[A.length-1]){
                    A[i]=A[A.length-1];
                }
            }

            return A[A.length-1]-A[0];
        }


    }
}