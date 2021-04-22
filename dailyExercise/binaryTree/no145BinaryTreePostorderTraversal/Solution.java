package binaryTree.no145BinaryTreePostorderTraversal;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-04-22 13:10
 */
public class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root==null){
            return list;
        }

        return list;


    }
    private void dfs(TreeNode root){
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);


        }

    }
    private void bfs(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right==null || root.right==prev){
                //左右都已经加入了

                list.add(root.val);
                prev = root;
                root = null;
            }else {
                //再装回去，然后继续往stack放

                stack.push(root);
                root=root.right;
            }
        }

    }
    private void bfsBack(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while(root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right==null || root.right==prev){
                list.add(root.val);
                prev = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }

        }
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
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
