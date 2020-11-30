package com.itranswarp.sample.contest;

import java.math.BigInteger;
import java.util.*;

public class D {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b =scanner.nextLong();
        long l1 = scanner.nextLong();
        long r1 = scanner.nextLong();
        long l2 = scanner.nextLong();
        long r2 = scanner.nextLong();
        long l3 = scanner.nextLong();
        long r3 = scanner.nextLong();
        long s = 0;
        BigInteger ans = new BigInteger(String.valueOf(s));

        if(l3<=l1){
            if(r3>=r1){
                ans=ans.add(BigInteger.valueOf((r1-l1+1)*a));
            }else {
                ans=ans.add(BigInteger.valueOf((r3-l1+1)*a));
            }
        }else {
            if(r3>=r1){
                ans=ans.add(BigInteger.valueOf((r1-l3+1)*a));
            }else {
                ans=ans.add(BigInteger.valueOf((r3-l3+1)*a));
            }
        }
        if(l3<=l2){
            if(r3>=r2){
                ans=ans.add(BigInteger.valueOf((r2-l2+1)*b));
            }else {
                ans=ans.add(BigInteger.valueOf((r3-l2+1)*b));
            }
        }else {
            if(r3>=r2){
                ans=ans.add(BigInteger.valueOf((r2-l3+1)*b));
            }else {
                ans=ans.add(BigInteger.valueOf((r3-l3+1)*b));
            }
        }

        BigInteger[] resBigIntegers = ans.divideAndRemainder(BigInteger.valueOf(1000000007));
        System.out.println(Arrays.toString(new BigInteger[]{resBigIntegers[1]}));
    }
}
