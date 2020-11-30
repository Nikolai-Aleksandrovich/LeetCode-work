package com.itranswarp.sample;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        while(root.left!=null){
            if(p.val<root.val&&q.val<root.val){
                root=root.left;
            }
            if(p.val>root.val&&q.val>root.val){
                root=root.right;
            }
            if(root.val==p.val||root.val==q.val){
                return root;
            }
            if((root.val>p.val&&root.val<q.val)||(root.val<p.val&&root.val>q.val)){
                return root;
            }
        }
        return root;

        /**
        if(p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
         */
    }

}