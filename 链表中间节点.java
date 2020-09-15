package com.itranswarp.sample;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ListNode middleNode(ListNode head) {
        //快慢指针，快指针一次走两步，满指针一次走一步，快指针到结尾，满指针到中间
        ListNode fast = head;
        ListNode slow = head;
        if(head == null){
            return head;
        }
        while (fast.next!=null){
            fast=fast.next.next;
            slow=fast.next;
        }
        return slow;
        /**
        //直接两遍遍历也可以
        int count = 0;
        if(head == null){
            return head;
        }
        ListNode temp = head;
        while (temp!=null){
            temp = temp.next;
            count++;
        }
        int index = 0;
        while (index!=count/2){
            head = head.next;
            index++;
        }
        return head;
         */

        /**
        //链表的缺点就是不能通过下标查询对应的值，直接转化为数组就会好一些
        ListNode[] queue = new ListNode[100];
        int count = 0;
        if(head == null){
            return head;
        }
        int t=0;
        while (head!=null){
            queue[t++]=head;
            head = head.next;
            count++;
        }
        return queue[count/2];
        */
        /**Queue<ListNode> queue = new LinkedList<ListNode>();
        ListNode ans = head;
        int count = 0;
        if(head == null){
            return head;
        }
        while (head!=null){
            queue.add(head);
            head = head.next;
            count++;
        }
        for (int i =0;i<count/2+1;i++){
            ans = queue.poll();
        }
        return ans;
         */
    }
}
