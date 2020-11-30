package com.itranswarp.sample;

import java.util.LinkedList;
import java.util.Queue;
//给你一个仅由数字 6 和 9 组成的正整数 num。
//
//你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
//
//请返回你可以得到的最大数字。
//
// 
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximum-69-number

public class Solution {
    public int maximum69Number (int num) {
        String s=String.valueOf(num);
        char[] chararray = s.toCharArray();
        for(int i =0;i<s.length();i++){
            if(chararray[i]=='6'){
                chararray[i]=9;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(chararray));
    }
}
