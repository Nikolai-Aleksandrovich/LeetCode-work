package binaryTree.no94binaryTreeInorderTraversal;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-04-22 10:49
 */
public class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root){
        dfs(root);
        return list;
    }
    private void dfs(TreeNode root){
        if (root!=null){
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }
    private void bfs(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while(root!=null && !stack.isEmpty()){
            TreeNode temp = stack.poll();
            if (temp.right!=null){
                stack.add(temp.right);
            }
            if (temp.left!=null){
                stack.add(temp.left);
            }
            list.add(temp.val);
        }
    }
    private void dfsMId(TreeNode node){
        if(node!=null){
            dfsMId(node.left);
            list.add(node.val);
            dfsMId(node.right);
        }

    }
    private void bfsMid(TreeNode node){
        Deque<TreeNode> deque = new LinkedList<>();

        while(!deque.isEmpty() || node!=null){
            while (node!=null){
                deque.add(node);
                node=node.left;
            }
            TreeNode temp =deque.pop();
            list.add(temp.val);
            node = temp.right;
        }
    }

}
class TreeNode{
    //TreeNode definition
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode leftNode,TreeNode rightNode){
        this.val = val;
        this.left = leftNode;
        this.right = rightNode;
    }
}
