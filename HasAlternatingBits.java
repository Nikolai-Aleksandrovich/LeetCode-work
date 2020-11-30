package com.itranswarp.sample;

public class HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int lastNum = 0;
        int firstNum = -1;
        if(n%2==0){
        }else {
            lastNum=1;
        }
        while(n!=0){
            firstNum = lastNum;
            n=n>>1;
            lastNum=(n)&1;
            System.out.println("f"+firstNum);
            System.out.println("l"+lastNum);
            if(firstNum==lastNum){
                return false;
            }
        }
        return true;
    }
}
