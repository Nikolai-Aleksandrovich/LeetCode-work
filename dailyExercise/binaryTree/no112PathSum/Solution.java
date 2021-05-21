package binaryTree.no112PathSum;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-19 0:14
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //加入根节点为空
        if (root == null) {
            return false;
        }
        //
        Deque<TreeNode> queNode = new LinkedList<>();//一个节点队列，一个值队列
        Deque<Integer> queVal = new LinkedList<>();
        //先把root放进两个队列中
        queNode.offerLast(root);
        queVal.offerLast(root.val);//首先把节点和值都放到两个队列
        while (!queNode.isEmpty()){
            //将当前节点取出
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

    public boolean hasPathSum1(TreeNode root,int targetSum){
        if (root == null){
            return false;
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> valueQueue = new LinkedList<>();
        nodeQueue.push(root);
        valueQueue.push(root.val);
        while(!nodeQueue.isEmpty()){
            TreeNode temp = nodeQueue.pop();
            int value = valueQueue.pop();
            if (temp.left==null&&temp.right==null){
                if (value==targetSum){
                    return true;
                }
            }
            if (temp.right!=null){
                nodeQueue.push(temp.right);
                valueQueue.push(temp.right.val+value);
            }
            if (temp.left!=null){
                nodeQueue.push(temp.left);
                valueQueue.push(temp.left.val+value);
            }
        }
        return false;

    }
    public boolean hasPathSum2(TreeNode root,int targetSum){
        if (root==null){
            return false;
        }
        if (root.left==null&&root.right==null){
            if (root.val==targetSum){
                return true;
            }
        }
        return hasPathSum2(root.left, targetSum-root.val)||hasPathSum2(root.right, targetSum-root.val);

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