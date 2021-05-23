package binaryTree.no226invertBinaryTree;



/**
 * @author Yuyuan Huang
 * @create 2021-05-22 22:28
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        dfs(root);
        return root;
    }
    private void dfs(TreeNode root){
        if (root==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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
