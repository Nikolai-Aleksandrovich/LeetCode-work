package com.itranswarp.sample;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeadSimilar {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    //用set做只会检查出现次数，而不会检查出现顺序，用双list做可以
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Set<Integer> set = new HashSet<>();
        dfs1(root1,set);
        dfs2(root2,set);
        return set.size()==0;


    }
    private void dfs1(TreeNode root1,Set<Integer> set){
        if(root1==null){
            return;
        }
        if(root1.left==null&&root1.right==null){
            if(set.add(root1.val)){

            }else {
                set.remove(root1.val);
            }
        }
        dfs1(root1.left,set);
        dfs1(root1.right,set);
    }
    private void dfs2(TreeNode root2,Set<Integer> set){
        if(root2==null){
            return;
        }
        if(root2.left==null&&root2.right==null){
           if(set.add(root2.val)){

           }else {
               set.remove(root2.val);
           }
        }
        dfs2(root2.left,set);
        dfs2(root2.right, set);
    }

}

