package no919CompleteBinaryTreeInserter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yuyuan Huang
 * @create 2021-06-03 11:54
 */
public class Solution {
}
class CBTInserter {
    Deque<TreeNode> deque;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
        deque = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node  = queue.poll();
            if (node.left==null || node.right==null){
                deque.offerLast(node);
            }
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }

    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left==null){
            node.left=deque.peekLast();
        }else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }
        return node.val;


    }

    public TreeNode get_root() {
        return root;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }