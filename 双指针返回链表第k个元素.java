public class Solution {
    public ListNode getKthFromEnd(ListNode head,int k){
        ListNode first = head;
        ListNode second = head;
        for(int i = 0;i<k-1;i++){
            second=second.next;
        }
        while(second.next!=null){
            first=first.next;
            second=second.next;
        }
        return first;
    }
}
