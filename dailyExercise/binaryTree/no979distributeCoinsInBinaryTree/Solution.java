package no979distributeCoinsInBinaryTree;

/**
 * @author Yuyuan Huang
 * @create 2021-06-07 17:15
 */
public class Solution {
    int move;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;

    }
    public int dfs(TreeNode node){
        int value = 0;
        if (node != null){
            int left = dfs(node.left);
            int right = dfs(node.right);
            value = node.val+left+right-1;
            move += Math.abs(left)+Math.abs(right);
        }
        return value;
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