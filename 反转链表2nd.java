package com.itranswarp.sample;
//反转链表，还会遇到的
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public ListNode reverseList(ListNode head) {
        //绕

        Stack<ListNode> stack =new Stack<ListNode>();

        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        if(stack.isEmpty()){
            return null;
        }
        ListNode prev = stack.pop();
        ListNode out = prev;
        while(!stack.isEmpty()){
            prev.next = stack.pop();
            prev = prev.next;
        }
        prev.next = null;
        return out;



        /**&#x9012;&#x5F52;&#x7684;&#x601D;&#x60F3;&#x662F;&#xFF0C;&#x8FDB;&#x5165;&#x5230;&#x6700;&#x540E;&#x4E00;&#x4E2A;&#x8282;&#x70B9;4->5->4,4.next=null,&#x8FD9;&#x6837;&#x4E00;&#x6B65;&#x4E00;&#x6B65;&#x9000;&#x51FA;&#x6765;
         * &#x5C31;&#x5B58;&#x5728;&#x53CD;&#x8F6C;&#x94FE;&#x8868;&#x7684;&#x64CD;&#x4F5C;;
         if(head==null||head.next==null){
         return head;
         }
         ListNode temp = reverseList(head.next);

         head.next.next = head;
         head.next = null;

         return temp;
         */
    }

}
/**ListNode front = head;
 ListNode latter = null;
 while(front!=null){
 ListNode temp = front.next;
 front.next=latter;
 latter = front;
 front=temp;
 }
 return latter;
 */