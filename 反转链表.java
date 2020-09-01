public class Solution {
    public ListNode reverseList(ListNode head) {
        //迭代的方法
//        ListNode prev = null;
//        ListNode curr = head;
//        while(curr!=null){
//            ListNode temp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = temp;
//
//        }
//        return prev;
        //用递归的方法
        if(head==null||head.next==null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }
}
