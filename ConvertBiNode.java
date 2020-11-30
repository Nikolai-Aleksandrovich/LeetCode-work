package com.itranswarp.sample;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
+
public class ConvertBiNode {
    TreeNode head = new TreeNode(-1);
    TreeNode prev = null;
    public TreeNode convertBiNode(TreeNode root) {
        dfs(root);
        return head.right;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev == null) {
            prev = root;
            head.next = root;
        } else {
            prev.right = root;
            prev = root;
        }
        root.left = null;
        dfs(root.right);
    }


    /**
     *
     * @param root
     */
    /*private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        if(prev == null){
            prev = root;
            head.right = root;
        }else {
            prev.right = root;
            prev=root;
        }
        if(root.left.left==null&&root.left.left.right==null&&root.right.left==null&&root.right.right==null){
            TreeNode temp = root;
            root=root.left;
            root.right=temp;
            root.left=null;
            root.right.right=temp.right;
            root.right.left = null;
        }
        */



    }
}
