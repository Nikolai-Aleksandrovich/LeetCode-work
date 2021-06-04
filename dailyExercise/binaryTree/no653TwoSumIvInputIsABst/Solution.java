package no653TwoSumIvInputIsABst;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yuyuan Huang
 * @create 2021-05-31 21:54
 */
public class Solution {
    Set<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return helper(root,k);
    }
    public boolean helper(TreeNode node,int k){
        if (node == null){
            return false;
        }
        if (set.contains(k-node.val)){
            return true;
        }else {
            set.add(node.val);
        }
        return helper(node.left,k)||helper(node.right,k);

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