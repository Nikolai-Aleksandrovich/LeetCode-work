package com.itranswarp.sample.contest;

import java.util.Scanner;

public class Fib {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();

        long b = scanner.nextLong();

        long n = scanner.nextLong();
        n=n+2;

        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        long h = 1000000007;
        long ans =  Math.round(Math.pow(goldenRatio, n)/ Math.sqrt(5));
        ans = ans%h;
        System.out.println(ans);
    }
}
