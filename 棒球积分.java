package com.itranswarp.sample;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String op:ops){
            if(op.equals("+")){
                int top = stack.pop();
                int newTop = stack.peek()+top;
                stack.push(top);
                stack.push(newTop);
            }else if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                int newTop = stack.peek()*2;
                stack.push(newTop);
            }else {
                stack.push(Integer.valueOf(op));
            }
        }
        int sum = 0;
        for (Integer element:stack){
            sum+=element;
        }
        return sum;

    }
}
