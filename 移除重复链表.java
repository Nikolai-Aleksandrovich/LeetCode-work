package com.itranswarp.sample;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<Integer>();
        if(head==null){
            return head;
        }
        ListNode var = head;
        set.add(var.val);
        while(var.next!=null){
            ListNode cur = var.next;
            if(set.add(cur.val)){
                var=var.next;
            }else {
                var.next=var.next.next;
            }
        }
        var.next = null;
        return head;




    }
}