package com.itranswarp.sample;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        //尝试一种空间复杂度为1的办法
        int j=1;
        for (int i=0;i<A.length;i+=2){
            if(A[i]%2==1){
                while (A[j]%2==1){
                    j+=2;
                }
                int temp = A[j];
                A[j]=A[i];
                A[i]=temp;
            }
        }
        return A;

        /**遍历一遍数组把所有的偶数放进 ans[0]，ans[2]，ans[4]，依次类推。

         再遍历一遍数组把所有的奇数依次放进 ans[1]，ans[3]，ans[5]，依次类推。

         * int[] list = new int[A.length];
        for (int i=0,j=0,k=1;i<A.length;i++){
            if(A[i]%2==0){
                list[j]=A[i];
                j+=2;
            }else {
                list[k]=A[i];
                k+=2;
            }
        }
        return list;
         */

        /**n^2 n
         * Queue<Integer> evenList = new LinkedList<>();
        Queue<Integer> oddsList = new LinkedList<>();
        for (int j : A) {
            if (j % 2 == 0) {
                evenList.add(j);
            } else {
                oddsList.add(j);
            }
        }
        for (int i=0;i<A.length;i++){
            if(i%2==0){
                A[i]=evenList.remove();
            }else {
                A[i]=oddsList.remove();
            }
        }
        return A;
         */
    }
}
