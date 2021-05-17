package binaryTree.no103binaryTreeZigzagLevelOrderTraversal;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-05-15 11:30
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOrder = true;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            if (isOrder){
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.pollFirst();
                    list.add(temp.val);
                    if (temp.left!=null){
                        queue.addLast(temp.left);
                    }
                    if (temp.right!=null){
                        queue.addLast(temp.right);
                    }
                    isOrder=false;

                }
            }else {
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.pollLast();
                    list.add(temp.val);
                    if (temp.right
                            !=null){
                        queue.addFirst(temp.right);
                    }
                    if (temp.left!=null){
                        queue.addFirst(temp.left);
                    }
                    isOrder= true;
                }

            }
            result.add(list);
        }
        return result;

    }
}
class TreeNode {
    int val;
TreeNode left;
   TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val,TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
