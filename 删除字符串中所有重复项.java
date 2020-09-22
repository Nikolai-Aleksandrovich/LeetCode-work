package com.itranswarp.sample;

import java.util.*;

public class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c:S.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else {
                if(stack.peek()==c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i=size-1;i>=0;i--){
            if(!stack.isEmpty()){
                sb.append(stack.pop());
            }
        }
        sb=sb.reverse();
        return sb.toString();
        /**StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character:S.toCharArray()){
            if(sbLength!=0&&character==sb.charAt(sbLength-1)){
                sb.deleteCharAt(sbLength-- - 1);
            }else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
         */
    }
}
