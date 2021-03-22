package no23mergeKLists;

/**
 * @author Yuyuan Huang
 * @create 2021-03-22 17:40
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        List<ListNode> list = new ArrayList<ListNode>();
        int [] nums = new int[length];
        for (int i = 0; i < length; i++) {
            list.add(lists[i]);
        }
        int minValue = Integer.MIN_VALUE;
        ListNode empty = new ListNode(0,null);
        while (!isListAllNull(list,length)){
            for (int i = 0; i < length; i++) {
                if(list.get(i)!=null){
                    Math.
                }
            }
        }
    }
    private boolean isListAllNull(List<ListNode> list,int length){
        for (int i = 0; i < length; i++) {
            if(list.get(i) !=null){
                return false;
            }
        }
        return true;
    }
//    public ListNode mergeKLists(ListNode[] lists) {
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (ListNode head:lists){
//            while (head!=null){
//                list.add(head.val);
//                head = head.next;
//            }
//        }
//        Collections.sort(list);
//        ListNode empty = new ListNode(0,null);
//
//        ListNode temp = empty;
//        for(int element:list){
//            temp.next = new ListNode(element,null);
//            temp = temp.next;
//        }
//        return empty.next;
//
//    }
}
