package com.itranswarp.sample;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans=0;
        dfs(root,L,R);
        return ans;
    }
    public void dfs( TreeNode root,int L,int R){
        if(root!=null) {
            if (L <= root.val && R >= root.val) {
                ans += root.val;
                dfs(root.left,L,R);
                dfs(root.right,L,R);
            }
            if (root.val > R) {
                dfs(root.left, L, R);
            }
            if (root.val < L) {
                dfs(root.right, L, R);
            }
        }
    }
}
