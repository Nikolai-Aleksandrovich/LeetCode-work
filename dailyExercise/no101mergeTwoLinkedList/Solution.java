package no101mergeTwoLinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-03-22 20:05
 */
public class Solution {
    public  ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoLinkedList(ans, list);
        }
        return ans;
    }

    public ListNode mergeTwoLinkedList(ListNode node1,ListNode node2){
        ListNode empty1 = new ListNode(0,null);
        ListNode empty = empty1;
        ListNode end = new ListNode(0,null);
        ListNode first = node1;
        ListNode second = node2;
        while (first!=null && second!=null){
            if(first.val>=second.val){
                empty.next=second;
                empty=second;
                second=second.next;
            }else {
                empty.next = first;
                empty=first;
                first=first.next;
            }
        }
        if(first==null){
            empty.next=second;
        }else {
            empty.next = first;
        }
        return empty1.next;
    }
}
