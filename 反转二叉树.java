package com.itranswarp.sample;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Greeting {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        root.right = queue.remove();
        root.left = queue.remove();
        invertTree(root.right);
        invertTree(root.left);
        return root;





        /**这是递归的方法，必须遍历所有节点时间复杂度为on，空间复杂度为on栈内需要存放 O(h)O(h) 个方法调用
        dfs(root);
        return root;

    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }

            TreeNode tempNode = root.left;

            root.left = root.right;
            root.right = tempNode;
            dfs(root.left);
            dfs(root.right);
         */
    }
}
