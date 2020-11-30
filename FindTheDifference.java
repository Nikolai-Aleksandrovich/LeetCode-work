package com.itranswarp.sample;

import java.util.HashMap;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int ans = t.charAt(t.length()-1);
        for (int i=0;i<s.length();i++){
            ans=ans^s.charAt(i)^t.charAt(i);
        }
        return (char)ans;

    /**
     * 两次hash遍历，再检查
     * public char findTheDifference(String s, String t) {
     *
     *         HashMap<Character,Integer> hashMap = new HashMap<>();
     *         for(char c:s.toCharArray()){
     *             hashMap.put(c,hashMap.getOrDefault(c,0)+1);
     *         }
     *         for (char c:t.toCharArray()){
     *             hashMap.put(c,hashMap.getOrDefault(c,0)-1);
     *         }
     *         for (char key:hashMap.keySet()){
     *             if(hashMap.get(key)==-1){
     *                 return key;
     *             }
     *         }
     *         return ' ';
     * @param s
     * @param t
     * @return
     */

    }
}
