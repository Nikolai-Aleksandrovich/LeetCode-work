package com.pratiace.fristpackage;
//个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
//
//

class Solution {
    public int subtractProductAndSum(int n) {
        int production = 1;
        int sum = 0;
        int result = 0;
        while(n>0){
            int iteration = n%10;
            production *=(iteration);
            sum += (iteration);
            n/=10;

        }
        result = production-sum;


        return result;

    }
}