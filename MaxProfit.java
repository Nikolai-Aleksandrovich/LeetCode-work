package com.itranswarp.sample;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]-prices[i]>0){
                ans=ans+prices[i+1]-prices[i];
            }
        }
        return ans;
    }
}
