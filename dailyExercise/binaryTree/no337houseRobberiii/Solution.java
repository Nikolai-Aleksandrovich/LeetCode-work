package binaryTree.no337houseRobberiii;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-05-24 11:11
 */
public class Solution {
    Map<TreeNode,Integer> GMap = new HashMap<>();
    Map<TreeNode,Integer> FMap = new HashMap<>();
    int res = 0;
    public int rob(TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode node){
        if (node==null){
            return;
        }
        dfs(node.left);
        dfs(node.right);

        int nodeG = Math.max(FMap.getOrDefault(node.left,0),GMap.getOrDefault(node.left,0))+Math.max(FMap.getOrDefault(node.right,0),GMap.getOrDefault(node.right,0));
        System.out.println("G"+nodeG);
        GMap.put(node,Math.max(FMap.getOrDefault(node.left,0),GMap.getOrDefault(node.left,0))+Math.max(FMap.getOrDefault(node.right,0),GMap.getOrDefault(node.right,0)));
        int nodeF = GMap.getOrDefault(node.left,0)+GMap.getOrDefault(node.right,0)+node.val;
        System.out.println("F"+nodeF);
        FMap.put(node,nodeF);
        res += Math.max(nodeF,nodeG);
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