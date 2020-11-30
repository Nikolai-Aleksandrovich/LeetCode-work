package com.itranswarp.sample;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        fillQueue(root,queue);
        int a =queue.size();
        int i = 0;
        while((2^i-1)<queue.size()){
                i++;}
        return a;
    }
    public void fillQueue(TreeNode root,Queue<TreeNode> queue){
        if(root.left==null&&root.right==null){
            queue.add(root);
            return;
        }
        queue.add(root);
        fillQueue(root.left,queue);
        fillQueue(root.right,queue);

    }




    /**if(root==null){/深度优先搜索，要用好递归，需要理解分而治之的道理
        return 0;
    }
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    return Math.max(leftDepth,rightDepth)+1;
    */






}
