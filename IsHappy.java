package com.itranswarp.sample;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public boolean isHappy(int n) {
        //finally the fast will be same as the slow if there's a loop,in contrast,
        // if final value is 1,while loop will eject

        int slowPointer = n;
        int fastPointer = getNumber(n);
        while (fastPointer!=1&&fastPointer!=slowPointer){
            fastPointer=getNumber(getNumber(fastPointer));
            slowPointer=getNumber(slowPointer);
        }
        return fastPointer==1;

    }
    //this function is to calculate the total value of a specific n
    private int getNumber(int n){
        int totalNum = 0;
        while (n>0){
            int temp = n%10;
            totalNum+=temp*temp;
            n=n/10;
        }
        return totalNum;
    }

    /**
     *
     * @param n judge a number is a happy number
     * @return  boolean
     */
    /*public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();//use Set to search if there is a number already in the set
        while (n!=1&&!set.contains(n)){//if you can not judge n is or isn't a happy number and the set isn't contains a number,so put this number into set and search for it's next number
            set.add(n);
            n=getNext(n);
        }
        return n==1;//return ture if is a happy num,if it's not a happy number,it will fell into a loop,once the loop is build,the n will come out

    }
    private int getNext(int n){//this is a function to calculate the number in number by count
        int totalSum = 0;
        while (n>0){
            int d = n%10;
            totalSum+=d*d;
            n=n/10;
        }
        return totalSum;
    }
    */


}
