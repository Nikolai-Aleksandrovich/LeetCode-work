package no606ConstructStringFromBinaryTree;

/**
 * @author Yuyuan Huang
 * @create 2021-05-28 22:38
 */
public class Solution {

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb = dfs(root);
        System.out.println(sb);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }
    private StringBuilder dfs(TreeNode node){
        StringBuilder stringBuilder = new StringBuilder();
        if (node==null){
            return stringBuilder;
        }
        if (node.left==null&&node.right==null){
            stringBuilder.append('(');
            stringBuilder.append(node.val);
//            stringBuilder.append(')');
        }else if (node.left==null){
            stringBuilder.append("()");
        }else {
            stringBuilder.append("(").append(node.val);
        }
        stringBuilder.append(dfs(node.left));
        stringBuilder.append(dfs(node.right));
        stringBuilder.append(")");
        return stringBuilder;
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