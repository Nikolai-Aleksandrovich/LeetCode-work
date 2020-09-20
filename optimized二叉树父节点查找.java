package com.itranswarp.sample;

import javax.swing.tree.TreeNode;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root!=null){
            if(root.val<p.val){
                root=root.right;
            }else if(root.val>q.val){
                root=root.left;
            }else break;
        }
        return root;
    }
}