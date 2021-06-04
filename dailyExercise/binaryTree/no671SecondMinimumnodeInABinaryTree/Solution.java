package no671SecondMinimumnodeInABinaryTree;

/**
 * @author Yuyuan Huang
 * @create 2021-06-02 15:30
 */
public class Solution {
    int value;
    int minValue ;
    int count = 0;
    public int findSecondMinimumValue(TreeNode root) {
        if (root==null){
            return -1;
        }
        if (root.left==null){
            return -1;
        }
        minValue = root.val;
        value = root.val;
        dfs(root);
        if (minValue == root.val){
            return -1;
        }
        return minValue;

    }
    private void dfs(TreeNode node){
        if (node==null){
            return;
        }
        if (count == 0 &&node.val!=value){
            minValue = node.val;
            count++;
            return;
        }
        if (node.val != value){
            minValue = Math.min(minValue,node.val);
            return;
        }
        dfs(node.left);
        dfs(node.right);
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