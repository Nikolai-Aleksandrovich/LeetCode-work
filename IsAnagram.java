package com.itranswarp.sample;

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] s2 = s.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }
    /**
     *
     * @param s
     * @param t
     * @return
     */
    /*public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> hashmap = new HashMap<>();
        for(char c : s.toCharArray()){
            hashmap.put(c,hashmap.getOrDefault(c,0)+1);
        }
        for (char c:t.toCharArray()){
            if(!hashmap.containsKey(c)){
                return false;
            }else {
                hashmap.put(c,hashmap.get(c)-1);
            }
        }
        for (char key:hashmap.keySet()){
            if(hashmap.get(key)!=0){
                return false;
            }
        }
        return true;
    }*/

}
