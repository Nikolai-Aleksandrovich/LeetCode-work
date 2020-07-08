package com.pratiace.fristpackage;

public class Solution {

        public String reverseLeftWords(String s, int n) {



            StringBuilder finalString1 = new StringBuilder(s.length());

            for (int i = n; i<s.length();i++){
                finalString1.append((s.toCharArray())[i]);
            }
            for(int i = 0; i<n; i++){
                finalString1.append((s.toCharArray())[i]);
            }
            return finalString1.toString();


//            String firstString = s.substring(0,n);
//            String secondString = s.substring(n,s.length());
//            String finalString = firstString+secondString; //切片函数
//            return finalString;
        }



        }
