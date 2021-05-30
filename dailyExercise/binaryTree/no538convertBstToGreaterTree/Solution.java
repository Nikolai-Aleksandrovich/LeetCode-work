package no538convertBstToGreaterTree;


/**
 * @author Yuyuan Huang
 * @create 2021-05-28 14:54
 */

public class Solution {
    int preValue = 0;
    public TreeNode convertBST(TreeNode root) {

        dfs(root,preValue);
        return root;
    }
    private void dfs(TreeNode node,int preValue){
        if (node == null){
            return;
        }
        dfs(node.right,preValue);
        node.val = node.val+preValue;
        preValue = node.val;
        System.out.println(preValue);
        dfs(node.left,preValue);
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