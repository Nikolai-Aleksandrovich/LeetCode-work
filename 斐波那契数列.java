package com.itranswarp.sample;

public class Solution {
    public int fib(int N){
        if(N<=1){
            return N;
        }
        if(N==2){
            return 1;
        }
        int current = 2;
        int prev1 = 1;
        int prev2 = 2;
        for (int i=3;i<N;i++){
            current=prev1+prev2;
            prev1 = prev2;
            prev2 = current;

        }
        return current;
    /**
     * private Integer[] cache = new Integer[31];
     *     public int fib(int N){
     *         if(N<=1) {
     *             return N;
     *         }
     *         cache[0] = 0;
     *         cache[1] = 1;
     *         return memoize(N);
     *     }
     *     private int memoize(int N){
     *         if(cache[N]!=null){
     *             return cache[N];
     *     }
     *         cache[N]=memoize(N-1)+memoize((N-2));
     *         return memoize(N);
     */

    /**
     * public int fib(int N) {
     *         if (N <= 1) {
     *             return N;
     *         }
     *         return memoize(N);
     *     }
     *     private int memoize(int N){
     *         int[] cache = new int[N+1];
     *         cache[1] = 1;
     *         for (int i=2;i<N;i++) {
     *             cache[i] = cache[i - 1] + cache[i - 2];
     *         }
     *         return cache[N];
     *     }

     */


        /**
         * if(N<=1){
         *             return N;
         *         }
         *         return fib(N-1)+fib(N-2);
         */

    /**
     * int ans = 0;
     *     public int fib(int N) {
     *         return helper(N,N);
     *     }
     *     private int helper(int N,int cur){
     *
     *         if(cur>N){
     *             return ans;
     *         }
     *         if(cur==0){
     *             return 0;
     *         }
     *         if(cur==1){
     *             return 1;
     *         }
     *         return helper(N,cur-1)+helper(N,cur-2);
     */


    }
}
