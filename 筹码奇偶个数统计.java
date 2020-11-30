package com.itranswarp.sample;

public class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0;
        for(int element:position){
            if(element%2==0){
                evenCount++;
            }
        }
        if(evenCount>position.length-evenCount){
            return position.length-evenCount;
        }else {
            return evenCount;
        }
    }

}
