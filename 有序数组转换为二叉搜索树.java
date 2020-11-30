package com.itranswarp.sample;
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 树 深度优先搜索
// 👍 570 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);




    }

    public TreeNode helper(int[] nums,int left,int right){
       if(left>right){
           return null;
       }
       int mid = (right+left)/2;
       TreeNode root=new TreeNode(nums[mid]);
       root.left = helper(nums,left,mid-1);
       root.right = helper(nums,mid+1,right);

       return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
