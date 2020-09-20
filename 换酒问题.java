package com.itranswarp.sample;

public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int curBottles = numBottles;
        while(curBottles>=numExchange){
            int exchangenum = curBottles/numExchange;
            curBottles=exchangenum+curBottles%numExchange;
            count+=exchangenum;
        }
        return count;
    }
    private void calculate(int count,int curBottles,int numExchange){
        if(curBottles<numExchange){
            return;
        }
        int exchange = curBottles/numExchange;//当前可换购的新饮料
        count=count+exchange;
        curBottles = curBottles/numExchange+curBottles%numExchange;//更新总瓶子数
        calculate(count,curBottles,numExchange);


    }
}
