package com.itranswarp.sample;

public class Solution1 {
    public boolean isUnique(String astr) {
        for(char as:astr.toCharArray()){
            if(astr.indexOf(as)!=astr.lastIndexOf(as)){
                return false;
            }
        }
        return true;
        /**for(int i = 0;i<astr.length();i++){//双重暴力循环
            for (int j=i+1;j<astr.length();j++){
                if (astr.charAt(i)==astr.charAt(j)){
                    return false;
                }
            }
        }
        return true;
         */

        /**int[] array = new int[26];使用了数组数据结构的桶排序
        for (int i =0;i<astr.length();i++){
            byte ascii = (byte)(astr.charAt(i));
            array[ascii-97]++;
        }
        for (int element:array){
            if(element>1){
                return false;
            }
        }
        return true;
         */
    }
}
