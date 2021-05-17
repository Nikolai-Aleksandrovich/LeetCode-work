package binaryTree.no95uniqueBinarySearchTreesii;

/**
 * @author Yuyuan Huang
 * @create 2021-05-14 16:29
 */

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
class Solution {
    public List<TreeNode> generateTrees(int n) {
        //当n为0时，直接返回空链表
        if (n==0){
            return new LinkedList<TreeNode>();
        }
        //不然就进行回溯
        return backTrace(1,n);

    }
    private List<TreeNode> backTrace(Integer start,Integer end){
        //先建立回溯返回值
        List<TreeNode> allTrees = new LinkedList<>();
        //越界
        if (start>end){
            allTrees.add(null);
            return allTrees;
        }
        //
        for (int i = start; i <end; i++) {
            List<TreeNode> leftTrees = backTrace(start,i-1);
            List<TreeNode> rightTrees = backTrace(i,end);
            for (TreeNode left:leftTrees
                 ) {
                for (TreeNode right: rightTrees
                     ) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);

                }

            }
        }
        return allTrees;
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