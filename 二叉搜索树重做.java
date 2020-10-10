package com.itranswarp.sample;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return null;
        }
        if(p.val>q.val){
            TreeNode temp = p;
            p=q;
            q=temp;
        }
        if(p.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
