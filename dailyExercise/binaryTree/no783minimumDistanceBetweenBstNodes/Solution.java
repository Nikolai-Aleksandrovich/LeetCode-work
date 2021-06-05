package no783minimumDistanceBetweenBstNodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-06-05 22:10
 */
public class Solution {
    List<Integer> list;
    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min,Math.abs(list.get(i-1)-list.get(i)));
        }
        return min;
    }
    public void dfs(TreeNode node){
        if (node!=null){
            dfs(node.left);
            list.add(node.val);
            dfs(node.right);
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