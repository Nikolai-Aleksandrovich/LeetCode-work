package com.itranswarp.sample;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prevhead=new ListNode(-1);
        ListNode pre = prevhead;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                prevhead.next=l1;
                prevhead=prevhead.next;
                l1=l1.next;
            }else{
                prevhead.next = l2;
                prevhead=prevhead.next;
                l2=l2.next;
            }
        }
        prevhead.next = l1==null? l2:l1;
        return pre.next;
    }

    /**
     * public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     *         if(l1==null){
     *             return l2;
     *         }else if (l2==null){
     *             return l1;
     *         }else if(l1.val<l2.val){
     *             l1.next=mergeTwoLists(l1.next,l2);
     *             return l1;
     *         }else{
     *             l2.next = mergeTwoLists(l1,l2.next);
     *             return l2;
     *         }
     *
     *
     *     }
     * @param l1
     * @param l2
     * @return
     */

}