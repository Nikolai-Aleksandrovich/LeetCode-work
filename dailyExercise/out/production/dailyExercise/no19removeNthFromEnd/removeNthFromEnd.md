## Algorithm

#### [19. 删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

### Description

给你一个链表，删除链表的倒数第 `n` 个结点，并且返回链表的头结点。

**进阶：**你能尝试使用一趟扫描实现吗？

```
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
```

### Solution1

```java
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode empty = new ListNode(0,head);
        int length = getLength(empty);
        ListNode cur = empty;

        for (int i = 0; i < length-n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = empty.next;
        return ans;

    }
    private int getLength(ListNode listnode){
        int length = 0;
        while (listnode.next!=null){
            length++;
            listnode=listnode.next;
        }
        return length;
    }
}
```

### solution2

```
public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode empty = new ListNode(0,head);
        ListNode cur = empty;

        while (cur!=null){
            stack.add(cur);
            cur=cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode ln = stack.pop();
        ln.next = ln.next.next;
        return empty.next;
    }
```

### solution3

```
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode empty = new ListNode(0,head);
        ListNode first = empty;
        ListNode second = empty;
        for (int i = 0; i < n; i++) {
            first=first.next;
        }
        while (first.next != null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return empty.next;
    }
```



### Discuss

#### 思路：

* 单链表一般需要加入一个dummy节点，来连接头节点，可以避免头节点的特殊性
* 方法一：第一次遍历获得链表长度，第二次遍历获得第length-n个值，改变指向 On，1
* 方法二：第一次遍历全部放去stack，第二次遍历弹出n个，然后改变栈顶的指向
* 方法三：第一个指针先走n步，然后第一二个指针一起走

## Review

## Tip

* 单链表一般需要加入一个dummy节点，来连接头节点，可以避免头节点的特殊性

## Share