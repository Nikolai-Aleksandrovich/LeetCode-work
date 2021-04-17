package no32LogestValidParentheses;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Yuyuan Huang
 * @create 2021-04-17 22:06
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                left++;
            }
            if(s.charAt(i)==')'){
                right++;
            }
            if (right == left){
                maxLength = Math.max(maxLength,2*right);
            }else if(right>left){
                right = 0;
                left = 0;
            }
        }
        left = right = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)==')'){
                right++;
            }else if(s.charAt(i)=='('){
                left++;
            }
            if (right==left){
                maxLength = Math.max(maxLength,right*2);
            }
            if(left>right){
                left = right = 0;
            }
        }
        return maxLength;
    }
    private int process(String s){
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                stack.add(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    ans = Math.max(ans,i-stack.peek());
                }
                if (!stack.isEmpty()){
                    stack.pop();
                    ans++;
                }
            }

        }
        return ans;
    }

}
