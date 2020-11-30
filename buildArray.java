package com.itranswarp.sample;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int[] pool = new int[n+1];
        for (int j : target) {
            pool[j]++;
        }

        int j= pool.length-1;

        while ((pool[j]!=1)){
                j--;
        }



                for (int k=1;k<j+1;k++){
                    if(pool[k]==1){
                        list.add("Push");
                    }else {
                        list.add("Push");
                        list.add("Pop");
                    }
                }



        return list;
    }
}
