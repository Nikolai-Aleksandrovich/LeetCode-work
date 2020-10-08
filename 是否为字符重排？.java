package com.itranswarp.sample;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        /**
         * 建立一个池
         * 建立一个需求
         * 需求大于池？
         * int[] pool = new int[26];
         *         int[] require = new int[26];
         *         for (char c:s1.toCharArray()){
         *             pool[(int)c-97]++;
         *         }
         *         for (char c:s2.toCharArray()){
         *             require[(int)c-97]++;
         *         }
         *         for (int i=0;i<26;i++){
         *             if(pool[i]<require[i]){
         *                 return false;
         *             }
         *         }
         *         return true;
         */

        /**
         * 当可以重复使用元素时
         * Set<Character> set = new HashSet<>();
         *         for (char c:s1.toCharArray()){
         *             set.add(c);
         *         }
         *         for (char c :s2.toCharArray()){
         *             if (!set.contains(c)){
         *                 return false;
         *             }
         *         }
         *         return true;
         */

    }
}
