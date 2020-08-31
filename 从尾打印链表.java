package com.itranswarp.sample;

import java.util.Stack;
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

public class Solution {
    public int[] reversePrint(ListNode head) {



        Stack<ListNode> stack = new Stack<ListNode>();

        ListNode temp = head;
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;

        }
        int size = stack.size();
        int[] ans = new int[size];

        for(int i = 0;i<size;i++){

            ans[i]=stack.pop().val;


        }
        return ans;

    }
}
