package com.itranswarp.sample.contest;

import java.math.BigInteger;
import java.util.Scanner;

public class H {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String a=scanner.next();
        String b=scanner.next();
        BigInteger n1=new BigInteger(a);
        BigInteger n2=new BigInteger(b);
        BigInteger ans=new BigInteger("1");
        BigInteger i=new BigInteger("0");
        BigInteger d=new BigInteger("1");
        for(;i.compareTo(n2)<0;i.add(d)){
            ans=ans.multiply(n1);
            }
        long c = 1000000007 ;
        BigInteger[] resBigIntegers = ans.divideAndRemainder(BigInteger.valueOf(c));
        System.out.println(ans);

        }


    }

