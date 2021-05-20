package no23mergeKLists;

/**
 * @author Yuyuan Huang
 * @create 2021-03-22 17:40
 */

import LinkedList.no160mergedLinkedList.ListNode;

import java.util.*;

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
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((x,y) ->x.val-y.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail= tail.next;
            if(tail.next!=null){
                queue.offer(tail.next);
            }
        }
        return head.next;
    }
//class Status implements Comparable<Status>{
//    int value;
//    ListNode cur;
//    public Status(int value,ListNode cur){
//        this.cur = cur;
//        this.value = value;
//    }
//    @Override
//    public int compareTo(Status o) {
//        return this.value- o.value;
//    }
//
//}
//public class Solution {
//    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<Status> queue = new PriorityQueue<Status>();
//        for (ListNode list : lists) {
//            if (list != null) {
//                queue.add(new Status(list.val, list));
//            }
//        }
//        ListNode head = new ListNode(0);
//        ListNode tail = head;
//        while (!queue.isEmpty()) {
//            Status f = queue.poll();
//            tail.next = f.cur;
//            tail = tail.next;
//            if (tail.next != null) {
//                queue.add(new Status(tail.next.val, tail.next));
//            }
//        }
//        return head.next;
//    }
//}

//    class Status implements  Comparable<Status>{
//        int val;
//        ListNode ptr;
//        Status(int val,ListNode ptr){
//            this.val = val;
//            this.ptr = ptr;
//        }
//        @Override
//        public int compareTo(Status o) {
//            return this.val-o.val;
//        }
//    }
//    PriorityQueue<Status> queue = new PriorityQueue<Status>();
//    public ListNode mergeKLists(ListNode[] lists) {
//        for (int i = 0; i < lists.length; i++) {
//            if(lists[i]!=null){
//                queue.add(new Status(lists[i].val,lists[i]));
//            }
//        }
//        ListNode head = new ListNode(0);
//        ListNode tail = head;
//        while (!queue.isEmpty()){
//            Status f = queue.poll();
//            tail.next = f.ptr;
//            if(f.ptr.next!=null){
//                queue.offer(new Status(f.ptr.next.val,f.ptr.next));
//            }
//        }
//        return head.next;
//    }
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0, lists.length-1);
    }
    private ListNode merge1(ListNode[] lists,int l,int r){
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid = (l+r)>>1;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    private ListNode mergeTwoLists(ListNode a,ListNode b){
        ListNode empty = new ListNode(0,null);
        ListNode temp = empty;
        ListNode headA = a;
        ListNode headB = b;
        while(headA!=null&&headB!=null){
            if(headA.val<=headB.val){
                temp.next = headA;
                temp=headA;
                headA = headA.next;
            }else {
                temp.next = headB;
                temp = headB;
                headB = headB.next;
            }
        }
        if(headA==null){
            temp.next = headB;
        }else {
            temp.next = headA;
        }
        return empty.next;
    }
//    public ListNode mergeKLists(ListNode[] lists) {
//        int length = lists.length;
//        List<ListNode> list = new ArrayList<ListNode>();
//        int [] nums = new int[length];
//        for (int i = 0; i < length; i++) {
//            list.add(lists[i]);
//        }
//        int minValue = Integer.MIN_VALUE;
//        ListNode empty = new ListNode(0,null);
//        while (!isListAllNull(list,length)){
//            for (int i = 0; i < length; i++) {
//                if(list.get(i)!=null){
//                    Math.
//                }
//            }
//        }
//    }
//    private boolean isListAllNull(List<ListNode> list,int length){
//        for (int i = 0; i < length; i++) {
//            if(list.get(i) !=null){
//                return false;
//            }
//        }
//        return true;
//    }
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

