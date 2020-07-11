package com.pratiace.fristpackage;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        //使用java中ArrayList类中的add(int index, Object o)函数即可将制定元素插入到指定位置。最后再将List中元素依次放到数组中即可。

        int n = index.length;
        List<Integer> res= new ArrayList<>();
        for(int i = 0;i<n;i++){
            res.add(index[i],nums[i]);
        }
        int[] target = new int[n];
        for(int i = 0; i<n;i++){
            target[i] = res.get(i);

        }
        return target;


    }
}
