package com.itranswarp.sample;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left!=null){
                    queue.add(left);
                }
                if(right!=null){
                    queue.add(right);
                }
            }
            ans.add(sum/size);
            }
        return ans;
        }

        /**List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        int level = 0;
        helper(root,level,sum,count);
        List<Double> ans = new ArrayList<>();
        for (int i=0;i<sum.size();i++){
            ans.add(sum.get(i)/count.get(i));
        }
        return ans;

    }

    private void helper(TreeNode root,int level,List<Double> sum,List<Integer> count){
        if(root==null){
            return;
        }
        if(sum.size()>level){
            sum.set(level,sum.get(level)+root.val);
            count.set(level,count.get(level)+1);
        }else {
            sum.add(1.0*root.val);
            count.add(1);
        }
        helper(root.left,level+1,sum,count);
        helper(root.right,level+1,sum,count);
         */
    }
}
