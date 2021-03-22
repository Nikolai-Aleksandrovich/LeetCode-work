package no20ValidKuoHao;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Yuyuan Huang
 * @create 2021-03-22 10:52
 */
public class Solution {
    public boolean isValid(String s){
        if(s.length()%2!=0){
            return false;
        }
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put('}','{');
        hashMap.put(']','[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(hashMap.containsKey(s.charAt(i))){
                if(stack.isEmpty()||stack.peek()!=hashMap.get(s.charAt(i))){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }

        }
        return true;


    }
}
