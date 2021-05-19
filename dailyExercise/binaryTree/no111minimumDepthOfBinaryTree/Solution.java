package binaryTree.no111minimumDepthOfBinaryTree;

import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-19 0:02
 */
public class Solution {
    public int minDepth(TreeNode root) {
        int level = 0;
        if (root==null){
            return level;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.pollFirst();
                if (temp.left==null&&temp.right==null){
                    return level;
                }
                if (temp.right!=null){
                    queue.addLast(temp.right);
                }
                if (temp.left!=null){
                    queue.addLast(temp.left);
                }
            }
        }
        return level;

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