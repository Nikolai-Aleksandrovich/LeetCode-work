package binaryTree.no129sumRootToLeafNumbers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-22 15:21
 */
public class Solution {
    Deque<TreeNode> nodeQueue = new LinkedList<>();
    Deque<Integer> valueQueue = new LinkedList<>();

    public int sumNumbers(TreeNode root) {
        int ans = 0;
        if (root==null){
            return ans;
        }
        nodeQueue.push(root);
        valueQueue.push(root.val);
        while (!nodeQueue.isEmpty()){
            TreeNode temp = nodeQueue.pollFirst();
            Integer value = valueQueue.pollFirst();
            if (temp.left!=null){
                nodeQueue.offerLast(temp.left);
                Integer tempValue = value*10+ temp.left.val;
                valueQueue.offerLast(tempValue);
            }
            if (temp.right!=null){
                nodeQueue.offerLast(temp.right);
                Integer tempValue = value*10+ temp.right.val;
                valueQueue.offerLast(tempValue);
            }
            if (temp.right==null&&temp.left==null){
                ans = ans+value;
            }


        }
        return ans;

    }
    Deque<TreeNode> queue = new LinkedList<>();
    int result = 0;
    int tempAns = 0;
    private void dfs(TreeNode node){
        if (node == null){
            return;
        }
        if (node.left==null&&node.right==null){
            tempAns = tempAns*10+ node.val;
            result = result+tempAns;
            tempAns = (tempAns- node.val)/10;
            return;
        }
        tempAns = tempAns*10+ node.val;
        dfs(node.left);
        dfs(node.right);
        tempAns = (tempAns- node.val)/10;
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