package com.pratiace.fristpackage;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        //给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
        //
        //J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
//暴力法：
//        int count = 0;
//        char[] stoneLib = S.toCharArray();
//        char[] myStone = J.toCharArray();
//        for(int i = 0;i<stoneLib.length;i++){
//            for(int j = 0; j<myStone.length; j++){
//                if(stoneLib[i]==(myStone[j])){
//                    count=count+1;
//                    break;
//                }
//            }
//
//        }
//
//        return count;
        int count = 0;
        Set<Character> stoneLib = new HashSet<>();
        for(char j:J.toCharArray()){
            stoneLib.add(j);
        }
        for(char s:S.toCharArray()){
            if(stoneLib.contains(s)){
                count++;
                break;
            }
        }
        return count;
    }

}
