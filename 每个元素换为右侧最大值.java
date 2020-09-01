package com.itranswarp.sample;

/***
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 *
 * 完成所有替换操作后，请你返回这个数组。
 * 这个方法从后往前算
 */
public class Solution {
    public int[] replaceElements(int[] arr) {

        int tempTempValue = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {



            int biggerOne = Math.max(arr[i+1],tempTempValue);

            tempTempValue = arr[i];
            arr[i] = biggerOne;
        }
        return  arr;
    }




    }

