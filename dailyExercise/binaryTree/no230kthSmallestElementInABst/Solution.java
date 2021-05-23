package binaryTree.no230kthSmallestElementInABst;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-05-22 22:31
 */
public class Solution {
    List<TreeNode> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return list.get(k-1).val;

    }
    private void dfs(TreeNode root,int k){
        if (root==null){
            return;
        }
        dfs(root.left,k);
        list.add(root);
        for (TreeNode node:list
             ) {
            System.out.println(node.val);
        }

        if (list.size()==k){
            return;
        }
        dfs(root.right,k);
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