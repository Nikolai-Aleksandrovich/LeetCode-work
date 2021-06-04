package no655PrintBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-06-02 12:20
 */
public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1<<height)-1];
        for (String[] arr :res
             ) {
            Arrays.fill(arr,"");

        }
        List<List<String>> ans = new ArrayList<>();
        fill();

    }
    public void fill(String[][] res,TreeNode root,int i,int l,int r){
        if (root==null){
            return;
        }
        res[i][(l+r)/2]=""+root.val;
    }
    public int getHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }