package binaryTree.no112PathSum;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-19 0:14
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> queNode = new LinkedList<>();//一个节点队列，一个值队列
        Deque<Integer> queVal = new LinkedList<>();
        queNode.offerLast(root);
        queVal.offerLast(root.val);//首先把节点和值都放到两个队列
        while (!queNode.isEmpty()){
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {//作为叶子节点
                if (temp==targetSum){//而且目标和为目标值//找到正确答案
                    return true;
                }
            }
            if (now.left!=null){
                queNode.offerLast(now.left);
                queVal.offerLast(now.left.val+temp);
            }
            if (now.right!=null){
                queNode.offerLast(now.right);
                queVal.offerLast(now.right.val+temp);
            }


        }
        return false;

    }
    private
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