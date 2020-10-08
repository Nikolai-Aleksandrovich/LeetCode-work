package com.itranswarp.sample;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans =0;
    int mod = 1000000000+7;
    public int sumRootToLeaf(TreeNode root) {
        helper(root,0);
        return ans%mod;
    }
    private void helper(TreeNode root,int sum){
        if(root!=null){
            sum=sum*2+root.val;
        }
        if(root.right==null&&root.left==null){
            ans=sum+ans;
        }else {
            helper(root.left,sum);
            helper(root.right,sum);
        }
    }
}