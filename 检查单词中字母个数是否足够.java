package com.itranswarp.sample;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] res = new int[26];
        int count = 0;
        for (char c:chars.toCharArray()){

                res[c-'a']++;

        }
        for (String word : words) {
            int[] temp = new int[26];
            for (char c : word.toCharArray()) {

                    temp[c - 'a']++;

            }
            if (isInMind(res, temp)) {
                count += word.length();
            }
        }
        return count;
    }
    private boolean isInMind(int[] a,int[] b){
        for (int i=0;i<26;i++){
            if(b[i]>a[i]){
                return false;
            }
        }
        return true;
    }
}
