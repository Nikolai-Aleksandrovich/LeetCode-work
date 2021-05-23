package binaryTree.no124binaryTreeMaximumPathSum;

import javax.swing.tree.TreeNode;

/**
 * @author Yuyuan Huang
 * @create 2021-05-22 14:46
 */
public class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        maxGain(root);
        return maxSum;
    }
    public int maxGain(TreeNode node){
        if (node==null){
            return 0;
        }
        int leftGain = Math.max(maxGain(node.left),0);
        int rightGain = Math.max(maxGain(node.right),0);
        int priceNewPath = leftGain+rightGain+node.val;
        maxSum = Math.max(maxSum,priceNewPath);
        return Math.max(leftGain,rightGain)+node.val;
    }
}
