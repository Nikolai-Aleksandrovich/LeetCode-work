package binaryTree.no117populatingNextRightPointersInEachNodeii;

import org.w3c.dom.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-22 0:03
 */
public class Solution {
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                Node temp = queue.pollFirst();
                if (size-i==1){
                    temp.next = null;

                }else {
                    temp.next = queue.peek();

                }
                System.out.println(temp.val+"'s next is "+temp.next.val);
                if (temp.left!=null){
                    queue.addLast(temp.left);
                }
                if (temp.right!=null){
                    queue.addLast(temp.right);
                }
            }

        }
        return root;

    }
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        root.left=null;
        helper(root);
        return root;

    }
    private void helper(Node node){
        if (node==null||(node.left==null&&node.right==null)){
            return;
        }
        if (node.left==null){
            Node temp = node.next;
            while (temp!=null&&(temp.left==null&&temp.right==null)){
                temp=temp.next;
            }
            if (temp==null){
                node.right.next =null;
                return;
            }
            if (temp.right!=null){
                node.right.next = temp.right;
            }
            if (temp.right==null&&temp.left!=null){
                node.right.next = temp.left;
            }
        }else if (node.right==null){
            Node temp = node.next;
            while (temp!=null&&(temp.left==null&&temp.right==null)){
                temp=temp.next;
            }
            if (temp==null){
                node.left.next =null;
                return;
            }
            if (temp.right!=null){
                node.left.next = temp.right;
            }
            if (temp.right==null&&temp.left!=null){
                node.left.next = temp.left;
            }
        }else {
            node.left.next = node.right;
            Node temp = node.next;
            while (temp!=null&&(temp.left==null&&temp.right==null)){
                temp=temp.next;
            }
            if (temp==null){
                node.right.next =null;
                return;
            }else if (temp.right!=null){
                node.right.next = temp.right;
            }else if (temp.right==null&&temp.left!=null){
                node.right.next = temp.left;
            }
        }
        helper(node.left);
        helper(node.right);

    }

        Node last = null, nextStart = null;

        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Node start = root;
            while (start != null) {
                last = null;
                nextStart = null;
                for (Node p = start; p != null; p = p.next) {
                    if (p.left != null) {
                        handle(p.left);
                    }
                    if (p.right != null) {
                        handle(p.right);
                    }
                }
                start = nextStart;
            }
            return root;
        }

        public void handle(Node p) {
            if (last != null) {
                last.next = p;
            }
            if (nextStart == null) {
                nextStart = p;
            }
            last = p;
        }
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
};
