package binaryTree.no110BalancedBinaryTree;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-18 17:07
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int maxHeight = 0;
        int minHeight = 50000;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node.left==null&&node.right==null){
                    maxHeight = Math.max(maxHeight,level);
                    minHeight = Math.min(minHeight,level);
                    System.out.println(maxHeight);
                    System.out.println(minHeight);
                }else if (node.left!=null){
                    queue.addLast(node.left);
                }else if (node.right!=null){
                    queue.addLast(node.right);
                }
            }
        }
        return maxHeight - minHeight <= 1;

    }
    public boolean isBalanced1(TreeNode root) {
        if (root==null){
            return true;
        }
        return Math.abs(heightCal(root.left) - heightCal(root.right))<=1 &&isBalanced1(root.left)&&isBalanced1(root.right);

    }
    private int heightCal(TreeNode node){
        if (node!=null&&node.left==null&&node.right==null){
            return 1;
        }else if (node==null){
            return 0;
        }else{
            return Math.max(heightCal(node.left),heightCal(node.right))+1;
        }

    }


    public int height(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight==-1||rightHeight==-1||Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight)+1;
        }
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