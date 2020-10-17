package com.itranswarp.sample;

public class GetInersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode mover1 = headA;
        ListNode mover2 = headB;
        while (mover1!=mover2){
            mover1= mover1==null? headB:mover1.next;
            mover2= mover2==null? headA:mover2.next;
        }
        return mover1;
    }
}
