package com.itranswarp.sample;

public class STuff {
    void initialize(int node, int b, int e, int M[MAXIND], int A[MAXN], int N)
    {
        if (b == e)
            M[node] = b;
        else
        {
            //compute the values in the left and right subtrees
            initialize(2 * node, b, (b + e) / 2, M, A, N);
            initialize(2 * node + 1, (b + e) / 2 + 1, e, M, A, N);

            //search for the minimum value in the first and
            //second half of the interval
            if (A[M[2 * node]] <= A[M[2 * node + 1]])
                M[node] = M[2 * node];
            else
                M[node] = M[2 * node + 1];
        }
    }
}
