package com.itranswarp.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int[] diffValue = new int[arr.length];
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0;i<arr.length-1;i++){
            diffValue[i]=arr[i+1]-arr[i];
        }
        int min = 1000000;
        for(int element:diffValue){
            if(element<min){
                min=element;
            }
        }
        for (int i = 0;i<diffValue.length-1;i++){
            if(diffValue[i]==min){
                list.add(new ArrayList<>());
                list.get(i).add(arr[i]);
                list.get(i).add(arr[i+1]);
            }
        }

        return list;
    }


}
