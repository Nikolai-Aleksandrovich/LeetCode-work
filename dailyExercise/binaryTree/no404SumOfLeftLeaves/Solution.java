package binaryTree.no404SumOfLeftLeaves;


/**
 * @author Yuyuan Huang
 * @create 2021-05-23 22:41
 */
public class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,1);
        return sum;

    }
    private void dfs(TreeNode node,int code){
        if (node==null){
            return;
        }
        if (node.left==null&&node.right==null){
            if (code==0){
                sum=sum+node.val;
            }
        }
        dfs(node.left,0);
        dfs(node.right,1);
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