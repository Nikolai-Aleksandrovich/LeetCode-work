package com.itranswarp.sample;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public int[] sortArrayByParity(int[] A) {
        //尝试快速排序，一种原地算法,不清楚为什么超时
        int i = 0;
        int j = A.length-1;
        while(i<j){
            if(A[i]%2>A[j%2]){
                int temp = A[i];
                A[i]=A[j];
                A[j]=temp;
            }
            if(A[i]%2==0){//key
                i++;
            }
            if(A[j]%2==1){//key
                j--;
            }

        }
        return A;

        /**
        //尝试排序算法,性能依然很差
        Integer[] B = new  Integer[A.length];
        for (int i=0;i<A.length;i++){
            B[i] = A[i];
        }
        Arrays.sort(B,(a,b)->Integer.compare(a%2,b%2));
        for (int i=0;i<A.length;i++){
            A[i] = B[i];
        }
        return A;
         */
        /**Queue<Integer> Oqueue = new LinkedList<>();//暴力算法，排名后10%如果把队列换成数组，只使用一个数组，两次遍历A，就是答案中的两遍扫描的方法
        Queue<Integer> Jqueue = new LinkedList<>();

        for (int j : A) {
            if (j % 2 == 0) {
                Oqueue.add(j);
            } else {
                Jqueue.add(j);
            }
        }
        int i=0;
        while (!Oqueue.isEmpty()){
            A[i++]=Oqueue.poll();
        }
        while (!Jqueue.isEmpty()){
            A[i++]=Jqueue.poll();
        }
        return A;
         */
    }
}
