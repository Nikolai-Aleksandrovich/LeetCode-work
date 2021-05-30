package no563binaryTreeTilt;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-05-28 19:21
 * 给定一个二叉树，计算 整个树 的坡度 。
 *
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 *
 * 整个树 的坡度就是其所有节点的坡度之和。
 */
public class Solution {
    Map<TreeNode,Integer> sumMap = new HashMap<>();
//    Map<TreeNode,Integer> ansMap = new HashMap<>();
    int ans;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode node){
        if (node == null){
            return;
        }
        dfs(node.left);
        dfs(node.right);
        if (node.left==null&&node.right==null){
            sumMap.put(node,node.val);
//            ansMap.put(node,0);
        }else {
            int leftValue = sumMap.getOrDefault(node.left,0);
            int rightValue = sumMap.getOrDefault(node.right,0);
            sumMap.put(node,leftValue+rightValue+ node.val);
            System.out.println("S");
            System.out.println(node.val);
            System.out.println(leftValue);
            System.out.println(rightValue);
            System.out.println("E");
            ans = ans+Math.abs(leftValue-rightValue);
//            ansMap.put(node,leftValue-rightValue);
        }


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