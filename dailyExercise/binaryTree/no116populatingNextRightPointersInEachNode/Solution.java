package binaryTree.no116populatingNextRightPointersInEachNode;

import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-21 23:22
 */
public class Solution {
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.pollFirst();
                if (size-i==1){
                    temp.next=null;
                }else {
                    temp.next = queue.peekFirst();
                }
                if (temp.left!=null){
                    queue.offerLast(temp.left);
                }
                if (temp.right!=null){
                    queue.offerLast(temp.right);
                }
            }

        }
        return root;
    }
    public Node connect1(Node root) {
        if (root==null){
            return null;
        }
        root.next = null;
        helper(root);
        return root;

    }
    private void helper(Node node){
        if (node == null||node.left==null){
            return;
        }

        node.left.next = node.right;
        if (node.next!=null){
            node.right.next = node.next.left;
        }else {
            node.right.next = null;
        }
        helper(node.left);
        helper(node.right);

    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}