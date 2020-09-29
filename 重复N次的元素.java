package com.itranswarp.sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int repeatedNTimes(int[] A) {
        for (int i=1;i<=3;i++) {
            for (int j = 0; j < A.length - i; j++) {
                if (A[j] == A[j + i]) {
                    return A[j];
                }
            }
        }
        return 0;

        /**Set<Integer> set = new HashSet<>();
        for (int element : A) {
            if (set.contains(element)) {
                return element;
            } else {
                set.add(element);
            }
         */

            /**Arrays.sort(A);
             int mid = A.length/2;
             if(A[mid]!=A[mid+1]){
             return A[mid-1];
             }else {
             return A[mid];
             }
             */
        }
        return 0;
    }
}
