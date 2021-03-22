package no19removeNthFromEnd;

import java.util.Stack;

/**
 * @author Yuyuan Huang
 * @create 2021-03-22 9:43
 * /**
 *  * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode() {}
 *  *     ListNode(int val) { this.val = val; }
 *  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  * }
 *  */

public class solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode empty = new ListNode(0,head);
//        ListNode first = empty;
//        ListNode second = empty;
//        for (int i = 0; i < n; i++) {
//            first=first.next;
//        }
//        while (first.next != null){
//            first=first.next;
//            second=second.next;
//        }
//        second.next=second.next.next;
//        return empty.next;
//    }
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        Stack<ListNode> stack = new Stack<ListNode>();
//        ListNode empty = new ListNode(0,head);
//        ListNode cur = empty;
//
//        while (cur.next!=null){
//            stack.add(cur.next);
//            cur=cur.next;
//        }
//        for (int i = 0; i < n; i++) {
//            stack.pop();
//        }
//        ListNode ln = stack.pop();
//        ln.next = ln.next.next;
//        return empty.next;
//    }
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode empty = new ListNode(0,head);
//        int length = getLength(empty);
//        ListNode cur = empty;
//
//        for (int i = 0; i < length-n; i++) {
//            cur = cur.next;
//        }
//        cur.next = cur.next.next;
//        ListNode ans = empty.next;
//        return ans;
//
//    }
//    private int getLength(ListNode listnode){
//        int length = 0;
//        while (listnode.next!=null){
//            length++;
//            listnode=listnode.next;
//        }
//        return length;
//    }
}
