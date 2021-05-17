package binaryTree.no98validateBinarySearchTree;

import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Yuyuan Huang
 * @create 2021-05-14 21:17
 */
public class Solution {
    List<Integer> list ;
    public boolean isValidBST(TreeNode root) {
        process(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    private void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    private void process(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right!=null){
                TreeNode temp = node.right;
                while (temp!=null){
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
    }
    private boolean helper(TreeNode root,int lower,int upper){
        if (root==null){
            return true;
        }
        if (root.val<=lower&&root.val>=upper){
            return false;
        }
        return helper(root.left,lower,root.val)&&helper(root.right,root.val,upper);
    }
    public boolean process1(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.pop();

            if (temp.left!=null){
                if (temp.left.val>=temp.val){
                    return false;
                }else {
                    queue.push(temp.left);
                }
            }
            if (temp.right!=null){
                if (temp.right.val<=temp.val){
                    return false;
                }else {
                    queue.push(temp.right);
                }
            }

        }
        return true;
    }
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}