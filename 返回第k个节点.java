import javax.swing.tree.TreeNode;
//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
public class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode a = head,b = head;
        for(int i = 0;i<k;++i) b=b.next;
        while(b!=null){
            a=a.next;
            b=b.next;
        }
        return a.val;

    }
}
