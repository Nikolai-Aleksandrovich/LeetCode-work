package binaryTree.no222countCompleteTreeNodes;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-22 21:55
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        //求得最深深度
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low<high){
            int mid = (high - low + 1) / 2 + low;
        }

    }
//    public int countNodes(TreeNode root) {
//
//        Deque<TreeNode> deque = new LinkedList<>();
//        if (root==null){
//            return 0;
//        }
//        int ans = 0;
//        deque.offerLast(root);
//        while (!deque.isEmpty()){
//            int size = deque.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = deque.pollFirst();
//                if (node.left!=null){
//                    deque.offerLast(node.left);
//                }
//                if (node.right!=null){
//                    deque.offerLast(node.right);
//                }
//                ans++;
//            }
//        }
//        return ans;
//    }
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