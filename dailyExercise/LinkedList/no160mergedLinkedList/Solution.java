package LinkedList.no160mergedLinkedList;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    ListNode tempA;
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode zero = headA;
        Deque<ListNode> stackA = new LinkedList<>();
        Deque<ListNode> stackB = new LinkedList<>();
        while (headA!=null){
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB!=null){
            stackB.push(headB);
            headB = headB.next;
        }
        while (!stackA.isEmpty()&&!stackB.isEmpty()){
            tempA = stackA.pop();
            ListNode tempB = stackB.pop();
            if (tempB.val==tempA.val&&tempB==tempA){

            }else {
                return tempB.next;
            }
        }
        if (stackA.isEmpty()&&stackB.isEmpty()){
            return zero;
        }else {
            return tempA;
        }
    }
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if (set.contains(headB)){
                return headB;
            }
        }

        return null;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        int count = 0;
        while (!(A.hashCode()==B.hashCode()&&A.equals(B))){
            if (A.next==null){
                A=headB;
            }else {
                if (count==0){
                    count++;
                    A=A.next;
                }else {
                    return null;
                }
            }
            if (B.next==null){
                B=headA;
            }else {
                B=B.next;
            }
        }
        return A;
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(){
    };
    ListNode(int val,ListNode next){
        this.val= val;
        this.next = next;
    }
}