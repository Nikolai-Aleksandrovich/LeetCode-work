package com.itranswarp.sample;

public class Solution1 {
    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        int next = 0;
        while (num!=0){
            next = next+num%10;
            num=num/10;
        }
        return addDigits(next);
    }

}
