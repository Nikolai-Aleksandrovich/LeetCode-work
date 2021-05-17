package binaryTree.no102binaryTreeLevelOrderTraversa;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-04-22 14:24
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root==null){
            return lists;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = deque.pollFirst();
                list.add(temp.val);
                if (temp.left!=null){
                    deque.offer(temp.left);
                }
                if (temp.right!=null){
                    deque.offer(temp.right);
                }
            }
            lists.add(list);
        }
        return lists;

    }
    private List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.pollFirst();
                list.add(temp.val);
                if (temp.left!=null){
                    queue.addLast(temp.left);
                }
                if (temp.right!=null){
                    queue.addLast(temp.right);
                }
            }
            result.add(list);
        }
        return result;

    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


