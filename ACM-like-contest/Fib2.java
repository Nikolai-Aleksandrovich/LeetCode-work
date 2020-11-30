package com.itranswarp.sample.contest;

import java.util.Scanner;

public class Fib2 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long n = scanner.nextLong();

        System.out.println(fib(n));

    }
    static long fib(long N) {
        if (N <= 1) {
            return N;
        }
        long[][] A = new long[][]{{1, 1}, {1, 0}};
        matrixPower(A, N-1);
        return A[0][0];

    }
    static void matrixPower(long[][] A, long N) {
        if (N <= 1) {
            return;
        }
        matrixPower(A, N/2);
        multiply(A, A);

        long[][] B = new long[][]{{1, 1}, {1, 0}};
        if (N%2 != 0) {
            multiply(A, B);
        }
    }
    static void multiply(long[][] A, long[][] B) {
        long x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        long y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        long z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        long w = A[1][0] * B[0][1] + A[1][1] * B[1][1];

        A[0][0] = x;
        A[0][1] = y;
        A[1][0] = z;
        A[1][1] = w;
    }
}
