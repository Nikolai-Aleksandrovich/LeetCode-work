package com.itranswarp.sample;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GetMinimumDifference {
    //the max size of this queue is 2
    Queue<TreeNode> queue = new LinkedList<>();
    //set n into a boundary to make sure I can capture minimize value
    int min = 1000000;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;

    }
    private void helper(TreeNode root){
        //end statement
        if(root == null){
            return;
        }
        //find the leftest node
        helper(root.left);
        queue.add(root);
        //in case of such situation that in first loop,the queue never add element

        if(queue.size()==2){
            //will not produce NullPointerException for the if statement
                min = Math.min(min,Math.abs(queue.poll().val-queue.peek().val));
        }
        helper(root.right);
    }

}
