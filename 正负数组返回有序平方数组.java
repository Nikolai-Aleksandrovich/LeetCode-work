package com.itranswarp.sample;

import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] A) {
        int head = 0;//双指针
        int end = A.length-1;
        int[] ans =new int[A.length];
        for(int i = A.length-1;i>=0;i--){
            if(head==end){
                ans[head]=(int)Math.pow(A[end],2);
                return ans;
            }
            if(Math.pow(A[head],2)<=Math.pow(A[end],2)){
                ans[i]=(int)Math.pow(A[end],2);
                end--;
            }else{
                ans[i]=(int)Math.pow(A[head],2);
                head++;
            }
            return ans;
        }
        /**
        for(int i=0;i<A.length;i++){
            A[i]=Math.abs(A[i]);
            A[i]=(int)Math.pow(A[i],2);
        }
        Arrays.sort(A);
        return A;
        for(int i=0;i<A.length;i++){
            A[i]=A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
         */

    }

}
