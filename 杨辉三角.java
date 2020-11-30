package com.itranswarp.sample;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows==0){//这是避免行为0
            return list;
        }
        list.add(new ArrayList<>());//第一行必然是1
        list.get(0).add(1);
        for (int rowNumber = 1;rowNumber<numRows;rowNumber++){
            List<Integer> curList = new ArrayList<>();
            List<Integer> prevList = list.get(rowNumber-1);
            curList.add(1);
            for (int i=1;i<rowNumber;i++){
                curList.add(prevList.get(i-1)+prevList.get(i));
            }
            curList.add(1);
            list.add(curList);
        }
        return list;

    }
}
