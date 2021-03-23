## Algorithm

#### [23. 合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)

### Description

给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

```
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6

```

### Solution1

```java
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
```

### solution2：

本人的方法：

```java
public ListNode mergeKLists(ListNode[] lists) {

        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode head:lists){
            while (head!=null){
                list.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(list);
        ListNode empty = new ListNode(0,null);

        ListNode temp = empty;
        for(int element:list){
            temp.next = new ListNode(element,null);
            temp = temp.next;
        }
        return empty.next;

    }
```

### solution3

```
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
```

### solution4

```
class Status implements Comparable<Status>{
    int value;
    ListNode cur;
    public Status(int value,ListNode cur){
        this.cur = cur;
        this.value = value;
    }
    @Override
    public int compareTo(Status o) {
        return this.value- o.value;
    }

}
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Status> queue = new PriorityQueue<Status>();
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(new Status(list.val, list));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.cur;
            tail = tail.next;
            if (tail.next != null) {
                queue.add(new Status(tail.next.val, tail.next));
            }
        }
        return head.next;
    }
```

### solution5

```
public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0, lists.length-1);
    }
    private ListNode merge(ListNode[] lists,int l,int r){
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
```



### Discuss

#### 思路：

* 子问题：合并两个有序链表：两个指针，分别对比两指针从头开始的值，谁小把谁加到empty节点之后，并指向空，当某一方耗尽，把另一方剩下的节点加入
* 解法一：两两处理，调用合并两个有序链表的子问题，第一次两两调用，是将第i个链表和null进行合并：
* 解法一时间：第一次合并0+n=n，第二次合并n+n=2n，第三次合并2n+n=3n，第k次合并k-1n+n=kn，总时间k方n，空间1
* 解法二：把所有节点值放入列表，对其排序，再串成链表，空间Kn，时间Kn
* 解法三：使用优先队列，注意在括号中声明排序的方式
* 解法四，优先级队列的一种变体，使用一个实现了Comparable接口的Stauts实现排序方式
* 解法五，分治，使用两两合并为一个，对每两个链表两两合并，每次数量减少k/2，

## Review

## Tip

* 可以看成树的深度优先搜索的顺序就是迭代器便利的顺序

## Share