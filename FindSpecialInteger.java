package com.itranswarp.sample;

import java.util.Arrays;
import java.util.HashMap;

public class FindSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        int before = arr.length / 4;
        for(int i = 0; before < arr.length; i++, before++){
            if(arr[i] == arr[before]) return arr[i];
        }
        return arr[arr.length-1];
    }

    /**
     *
     * @param arr   a list,must contain a number count more than total length/4
     * @return      return the longest and the specific length of number >arr.length
     */
    /*public int findSpecialInteger(int[] arr) {
        // use a hashmap store the number of all number
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int element:arr){
            hashMap.put(element,hashMap.getOrDefault(element,0)+1);
        }
        int ans = 0;
        //find the biggest or the one satisfy the condition that ans > arr.length/4
        for (int key:hashMap.keySet()){
            ans = Math.max(hashMap.get(key),ans);
            if(ans > arr.length/4){
                return key;
            }
        }
        return 0;
    }*/
    //actually,the first function and this function is the same idea with different tools.
    /*public int findSpecialInteger(int[] arr) {
        //a list to store the bucket
        int[] pool = new int[100000+1];
        for (int element:arr){
            pool[element]++;
            //if any value bigger than certain number,return the element
            if(pool[element]>arr.length/4){
                return element;
            }
        }

        return 0;
    }*/
    //binary search method
    /*public int findSpecialInteger(int[] arr) {
        return helper(0, arr.length-1, arr) ;
    }
    private int helper(int lo,int hi,int[] arr){
        if(lo<hi){
            return
        }
        int length = arr.length;

            int mid = (hi-lo)/2;
            if(mid-lo>length/4){
                if(arr[mid]==arr[lo]){
                    return mid;
                }
            }
            if(hi-mid>length/4){
                if(arr[mid]==arr[hi]){
                    return mid;
                }
            }
            helper(lo,mid-1,arr);
            helper(mid+1,hi,arr);

        return 0;
    }*/
}
