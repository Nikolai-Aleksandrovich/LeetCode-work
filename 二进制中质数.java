package com.itranswarp.sample;

public class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = 0; i <= R - L; i++) {
//            int number = L+i;
//            int temp = 0;
//            while(number!=0){
//                (number)=(number-1)&(number);
//                temp++;
//            }
            int temp = Integer.bitCount(L + i);
            if (helper(temp)) {
                count++;
            }
        }
        return count;

    }

    private boolean helper(int feedin) {
        int[] pool = {2, 3, 5, 7, 11, 13, 17, 19};
        for (int element : pool) {
            if (element == feedin) {
                return true;
            }
        }
        return false;
    }
}
