package com.itranswarp.sample;

import java.util.Arrays;

public class NumSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //transfer element of queries and words into number and put it into lists,finally,compare these lists and return the differences
        int[] queriesCount = new int[queries.length];//queries list
        int[] wordsCount = new int[words.length];//words list
        int[] ans = new int[queries.length];
        int a = 0;
        int b = 0;
        //for each s in queries,transfer it into number follow the order
        for(String s:queries){
            char[] temp =s.toCharArray();
            int minChar = 122;
            for(char c:temp){
                minChar =  Math.min(c,minChar);
            }
            int num = 0;
            for (char c:temp){
                if(c==minChar){
                    num++;
                }
            }
            queriesCount[a++]=num;
        }
        System.out.println(Arrays.toString(queriesCount));
        //for each s in words,transfer it into number follow the order
        for (String s:words){
            char[] temp =s.toCharArray();
            int minChar = 122;
            for(char c:temp){
                minChar =  Math.min(c,minChar);
            }
            int num = 0;
            for (char c:temp){
                if(c==minChar){
                    num++;
                }
            }
            wordsCount[b++]=num;
        }
        System.out.println(Arrays.toString(wordsCount));
        int c = 0;
        //compare two list,and send result into a new list
        for (int source:queriesCount){
            int count = 0;
            for (int pool:wordsCount){


                if(pool>source){
                    count++;
                }
            }
            ans[c++]=count;

        }

        return ans;
    }
}
