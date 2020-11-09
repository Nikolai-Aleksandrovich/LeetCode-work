package com.itranswarp.sample.contest;

import java.util.Scanner;

public class H1 {
    private static long pow(long a,long n) {
        if(n==0) return 1;
        long res=a;
        long ex=1;
        while((ex<<1)<=n) {
            res*=res;
            ex<<=1;
        }
        return res*pow(a,n-ex);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long ans = pow(a,b);
        long c = 1000000007;
        ans = ans%c;
        System.out.println(ans);
    }
}
