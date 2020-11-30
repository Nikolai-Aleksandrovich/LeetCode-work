package com.itranswarp.sample;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root==null){
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        nodeQueue.add(root);
        pathQueue.add(Integer.toString(root.val));
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.remove();
            String s = pathQueue.poll();
            if(node.left==null&&node.right==null){
                paths.add(s);
            }else {
                if(node.left!=null){
                    nodeQueue.add(node.left);
                    pathQueue.offer(new StringBuffer(s).append("->").append(node.left.val).toString());

                }if(node.right!=null){
                    nodeQueue.add(node.right);
                    pathQueue.add(new StringBuffer(s).append("->").append(node.right.val).toString());

                }

            }
        }
        return paths;
    }

    /**
     *public List<String> binaryTreePaths(TreeNode root) {
     *         List<String> paths = new ArrayList<>();
     *         constructPaths(root,"",paths);
     *         return paths;
     *
     *     }
     *     private void constructPaths(TreeNode root,String path,List<String> paths){
     *         if(root!=null){
     *             StringBuffer pathSB= new StringBuffer(path);
     *             pathSB.append(Integer.toString(root.val));
     *             if(root.left==null&&root.right==null){
     *                 paths.add(pathSB.toString());
     *             }else {
     *                 pathSB.append("->");
     *                 constructPaths(root.left,pathSB.toString(),paths);
     *                 constructPaths(root.right,pathSB.toString(),paths);
     *             }
     *
     *         }
     *     }
     */

}