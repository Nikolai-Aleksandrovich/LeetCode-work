package com.itranswarp.sample;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(root,0,list);
        return list;
        /**Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.remove();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            stack.push(list);
        }

        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
         */
    }
    private void helper(TreeNode root,int depth,List<List<Integer>> list){
        if(root==null){
            return;
        }
        if(depth==list.size()){
            list.add(0,new ArrayList<>());
        }
        list.get(list.size()-depth-1).add(root.val);
        helper(root.left,depth+1,list);
        helper(root.right,depth+1,list);
    }
}