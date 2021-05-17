package binaryTree.no104maximumDepthOfBinary;

/**
 * @author Yuyuan Huang
 * @create 2021-05-15 14:32
 */
public class Solution {
    int count = 0;
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }


    }
    private void dfs(TreeNode root){
        if (root==null){
            return;
        }
        count++;
        dfs(root.left);
        dfs(root.right);

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
