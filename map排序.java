package com.itranswarp.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //计数排序
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for (int element:arr1){
            if(hashmap.containsKey(element)){
                hashmap.put(element,hashmap.get(element)+1);
            }else {
                hashmap.put(element,1);
            }}
        int i = 0;
        for (int element:arr2){
            if(hashmap.containsKey(element)){
                while (hashmap.get(element)!=0){
                hashmap.put(element,hashmap.get(element)-1);
                arr1[i++]=element;}
            }
            }
        int[] list = new int[hashmap.size()];
        int j=0;
        for (Integer element: hashmap.keySet()){
            if(hashmap.get(element)!=0){
                list[j++]=element;
                hashmap.put(element,hashmap.get(element)-1);

            }
        }
        Arrays.sort(list);
        for (int a=0;a<j;a++){
            arr1[a+]
        }

        /**Set<Integer> mutualElement = new HashSet<>();
        Set<Integer> singleElement = new HashSet<>();
        for(int element:arr2){
            mutualElement.add(element);
        }

        for(int i=0,j=0,k=0;i<arr1.length;i++){
            if(!mutualElement.contains(arr1[i])){
                singleElement.add(arr1[i]);
            }else {
                arr1[j]=arr2[j];
                j++;
            }
        }
        Arrays.sort(singleElement.toArray());
        for (int i=0;i<singleElement.size();i++){
            arr1[arr2.length+i]=s
         */


        return arr1;
    }
}
