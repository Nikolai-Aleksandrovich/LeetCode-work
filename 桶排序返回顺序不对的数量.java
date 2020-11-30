package com.itranswarp.sample;

public class Solution {
    public int heightChecker(int[] heights) {
        int count=0;
        int[] arr = new int[101];//表示最大有100种身高的人站在同一排，而101代表有101个身高槽，设置了一个0身高槽，但其实这个槽没有人
        for (int height:heights){//把所有人按照身高入桶，每个桶的index就是这个桶的人的身高
            arr[height]++;
        }
        for(int i = 1,j=0;i<arr.length;i++){//遍历所有的桶
            while(arr[i]-->0){//遇到一个桶。每次减一，对每一个这个位置上的人判断他是不是应该
                if (heights[j++]!=i){
                    count++;
                }
            }

        }
        return count;

    }
}
