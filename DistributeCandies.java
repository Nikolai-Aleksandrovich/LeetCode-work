package com.itranswarp.sample;

import java.util.Map;

public class DistributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int iterateTime = distributeTime(candies);
        int fullIterate = (1+iterateTime)*iterateTime/2;
        int lastKid = candies-fullIterate;
        int[] ans = new int[num_people];
        for(int i=0,j=0;i<iterateTime;i++,j++){
            if(j==num_people){
                j=0;
            }
            ans[j]+=i+1;
            if(i==iterateTime-1){
                if(j+1==num_people){
                    j=-1;
                }
                ans[j+1]+=lastKid;
            }
        }
        return ans;

    }
    private int distributeTime(int candies){
        double time = (Math.sqrt(1+8*(double)candies)-1)/2;//注意，这里的8倍直接溢出，会出现全是0的情况
        return (int) Math.floor(time);
    }
}
