## Algorithm

2.[两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

### Description

给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

```
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
```

### Solution

```java
public class Solution {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode head = null,tail =null;
        int carry = 0;
        while(l1!=null||l2!=null){
            int n1=l1!=null ? l1.val:0;
            int n2= l2!=null ? l2.val:0;
            int sum = n1+n2+carry;
            if(head==null){
                head=tail=new ListNode(sum%10);
            }else{
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry=sum/10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry>0){
            tail.next = new ListNode(carry);
        }
        return head;

    }
}

```

### Discuss

#### 思路：

两链表都是逆序放置，同一位的数字相加得到：n1+n2+carry，其中n1来自链表1，n2来自链表2，carry来自进位，当某一链表短，另一链表长，则设置他的数字全部为0；将sum%10放在本位链表，sum/10放在下位carry，代码基本思路：

* 设置head，tail
* 当两表中任意一表不为空，则得到n1，n2，加上上位carry，设置本位数字值，下位carry，并将链表下移
* 最后加上最后carry，返回head



## Review

## Tip

## Share