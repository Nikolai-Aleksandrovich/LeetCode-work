package com.itranswarp.sample;

import java.lang.reflect.Array;
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
public class Solution {
    public String replaceSpace(String s) {
        int length =s.length();
        char[] array = new char[3*length];
        int size = 0;
        for(int i = 0;i<length;i++){
            if(s.charAt(i)==' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else {
                array[size++] = s.charAt(i);
            }
        }
        return new String(array,0,size);


    }
}
