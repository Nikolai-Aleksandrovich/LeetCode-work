package com.itranswarp.sample;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

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
    public boolean isUnivalTree(TreeNode root) {
        boolean leftCorrect = (root.left==null||(root.val==root.left.val&&isUnivalTree(root.left)));
        boolean rightCorrect = (root.right == null||(root.val==root.right.val&&isUnivalTree(root.right)));
        return leftCorrect&&rightCorrect;
    }

}
    /**取出所有数，放到一个List，再比较
    List<Integer> value;
    public boolean isUnivalTree(TreeNode root) {
        value = new ArrayList<>();
        dfs(root);
        for(Integer element:value){
            if(!element.equals(value.get(0))){
                return false;
            }
        }
        return true;

    }
    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        value.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
     */