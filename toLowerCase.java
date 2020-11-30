package com.itranswarp.sample;
//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。


public class Solution {
    public String toLowerCase(String str) {
        char[] product = str.toCharArray();
        for(int i = 0;i<product.length;i++){
            if(product[i]<=90 && product[i]>=65){
                product[i]= (char) (product[i]+32);
            }
        }
        return String.valueOf(product);
    }
}
