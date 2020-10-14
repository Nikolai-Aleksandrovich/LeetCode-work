package com.itranswarp.sample;

import java.util.List;

public class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A,B,C);
    }
    private void move(int n,List<Integer> A, List<Integer> B, List<Integer> C){
        if(n==1){
            C.add(A.remove(A.size()-1));
        }else {
            move(n-1,A,C,B);
            C.add(A.remove(A.size()-1));
            move(n-1,B,A,C);
        }

    }

    /**
     * 理解错误
     * public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
     *         int sizeOfA=A.size();
     *         C.add(A.remove(A.size()-1));
     *         while(!A.isEmpty()){
     *             if(B.isEmpty()){
     *                 B.add(A.remove(A.size()-1));
     *                 for(int i=C.size()-1;i>=0;i--){
     *                     B.add(C.remove(i));
     *                 }
     *
     *             }else if(C.isEmpty()){
     *                 C.add(A.remove(A.size()-1));
     *                 for(int i=B.size()-1;i>=0;i--){
     *                     C.add(B.remove(i));
     *                 }
     *             }
     *         }
     *         if(C.isEmpty()){
     *             C=B;
     *         }
     *     }
     * @param A
     * @param B
     * @param C
     */

}
