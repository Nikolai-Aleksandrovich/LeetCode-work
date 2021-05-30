package no617MergeTwoBinaryTrees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yuyuan Huang
 * @create 2021-05-28 23:11
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null&&root2==null){
            return null;
        }else if (root1==null||root2==null){
            return root2==null? root1:root2;
        }
        Deque<TreeNode> dequeTree1 = new LinkedList<>();
        Deque<TreeNode> dequeTree2 = new LinkedList<>();
        dequeTree1.push(root1);
        dequeTree2.push(root2);
        while (!dequeTree1.isEmpty()){
            int size = dequeTree1.size();
            for (int i = 0; i < size; i++) {
                TreeNode tree1 = dequeTree1.pollFirst();
                TreeNode tree2 = dequeTree2.pollFirst();
                System.out.println(tree1);
                System.out.println(tree2);
                if (tree1.val==0||tree2.val==0){
                    tree1.val = tree1.val+ tree2.val;
                }
                else if (tree1.left==null&&tree2.left==null&&tree1.right==null&&tree2.right==null){
                    tree1.val = tree1.val+ tree2.val;
                }else {

                    if (tree2.right != null && tree1.right != null) {
                        dequeTree1.offer(tree1.right);
                        dequeTree2.offer(tree2.right);
                    } else {
                        if (tree1.right == null) {
                            dequeTree1.offer(new TreeNode(0));
                            dequeTree2.offer(tree2.right);
                        } else {
                            dequeTree2.offer(new TreeNode(0));
                            dequeTree1.offer(tree1.right);
                        }
                    }
                    if (tree2.left != null && tree1.left != null) {
                        dequeTree1.offer(tree1.left);
                        dequeTree2.offer(tree2.left);
                    } else {
                        if (tree1.left == null) {
                            dequeTree1.offer(new TreeNode(0));
                            dequeTree2.offer(tree2.left);
                        } else {
                            dequeTree2.offer(new TreeNode(0));
                            dequeTree1.offer(tree1.left);
                        }
                    }
                    tree1.val = tree1.val+ tree2.val;
                }

            }

        }
        return root1;


    }
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }if (t2==null){
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val+t2.val);
        merged.left = mergeTrees1(t1.left,t2.left);
        merged.right = mergeTrees1(t1.right,t2.right);
        return merged;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }if (t2==null){
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val+t2.val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;

    }

}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }