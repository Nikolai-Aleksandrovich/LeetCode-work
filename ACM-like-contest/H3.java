package com.itranswarp.sample.contest;

import java.util.Scanner;

public class H3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long ans=powerByBinary(a,b);
        long c = 1000000007;

        System.out.println(ans);
        ans = ans%c;
        System.out.println(ans);
    }
    private static long powerByBinary(long x, long n) {
        if (n == 0 ) {
            return 1;
        }
        if (n == 1 ) {
            return x;
        }
        long y = 1;
        String str = Long.toBinaryString(n);
        for (int a = 0; a < str.length(); a++) {
            // char类型转化为int
            long s = Long.parseLong(String.valueOf(str.charAt(a)));
            y = y * y;
            if (s == 1) {
                y = y * x;
            }
        }
        return y;
    }


}
