package binaryTree.flattenBinaryTreeToLinkedList;


import LinkedList.no160mergedLinkedList.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-20 16:59
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode rootAns = root;
        TreeNode  node = root;
        while(node!=null){
            root.right = node;
            stack.push(node);
            root = root.right;
            node = node.left;
        }
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (temp.right!=null){
                TreeNode temp1 = temp.right;
                while(temp1!=null){
                    root.right = temp1;
                    root = root.right;
                    stack.push(temp1);
                    temp1= temp1.left;
                }
            }
        }
        root = rootAns;
    }
    public void flatten1(TreeNode root) {
        if (root==null){
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root1 = root;
        stack.push(root1);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (temp.right!=null){
                stack.push(temp.right);
            }
            if (temp.left!=null){
                stack.push(temp.left);
            }
            root1.right = temp;
            root1.left = null;
            root1 = temp;
        }
        root.left =null;
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
