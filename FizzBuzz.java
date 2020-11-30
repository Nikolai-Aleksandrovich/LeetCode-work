package com.itranswarp.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(3,"Fizz");
        hashMap.put(5,"Buzz");
        for (int i=1;i<n+1;i++){
            String numAnsStr="";
            for (Integer key : hashMap.keySet()){
                if(i%key==0){
                    numAnsStr+=hashMap.get(key);
                }
            }
            if(numAnsStr.equals("")){
                numAnsStr+=i;
            }
            list.add(numAnsStr);
        }
        return list;
    }
    /**
     * 进一步缩减判断
     * public List<String> fizzBuzz(int n) {
     *         List<String> ans = new ArrayList<String>();
     *         for (int num=1;num<n+1;num++){
     *             boolean devideBy3=(num%3==0);
     *             boolean devideBy5=(num%5==0);
     *             String numAnsStr="";
     *             if(devideBy3){
     *                 numAnsStr+="Fizz";
     *             }
     *             if(devideBy5){
     *                 numAnsStr+="Buzz";
     *             }
     *             if(numAnsStr.equals("")){
     *                 numAnsStr+=num;
     *             }
     *             ans.add(numAnsStr);
     *         }
     *         return ans;
     *     }
     * @param n
     * @return
     */


    /**
     * 模拟法
     *
     * public List<String> fizzBuzz(int n) {
     *         List<String> list = new ArrayList<>();
     *         for(int i=1;i<n+1;i++){
     *             if(i%3==0&&i%5==0){
     *                 list.add("FizzBuzz");
     *             }else if (i%3==0){
     *                 list.add("Fizz");
     *             }else if(i%5==0){
     *                 list.add("Buzz");
     *             }else {
     *                 list.add(i+"");
     *             }
     *         }
     *         return list;
     *     }
     * @param n
     * @return
     */

}
