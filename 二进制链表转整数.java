package com.pratiace.fristpackage;
//给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
//
//请你返回该链表所表示数字的 十进制值 。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode cur = head;

        while (cur != null){
            ans <<= 1;
            ans+=cur.val;
            cur=cur.next;

        }
        return ans;

    }
}
//a=a<<2 就可以写成 a<<=2
//<<是位运算符里的左移 a对应内存里的存储的二进制码向左移2位
//如：a=4 0000 0100左移2位 0001 0000
//链表移动到右侧下一个节点的过程，其实就是二进制数左移1位的结果