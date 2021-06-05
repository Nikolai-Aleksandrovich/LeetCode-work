package no897IncreasingOrderSearchTree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-06-04 10:21
 */
public class Solution {
    List<Integer> list;
    TreeNode temp;
    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();

        bfs(root);
        TreeNode node = new TreeNode(-1);

        temp = node;
        for (int i=0;i<list.size();i++) {
            node.right = new TreeNode(list.get(i));
            node = node.right;
        }
        return temp;
    }
    private void bfs(TreeNode node){
        if (node == null){
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        while(node!=null){
            deque.push(node);
            node = node.left;
        }
        while(!deque.isEmpty()){
            TreeNode temp = deque.pop();
            list.add(temp.val);
            if (temp.right!=null){
                TreeNode right = temp.right;
                while(right!=null){
                    deque.push(right);
                    right = right.left;
                }
            }
        }
    }

}
class AnotherSolution{
    private TreeNode resNode;
    public TreeNode increasingBST(TreeNode root){
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(resNode);
        return dummyNode.right;


    }
    public void inorder(TreeNode node){
        if (node==null){
            return;
        }
        inorder(node.left);
        resNode.right=node;
        node.left = null;
        resNode = node;
        inorder(node.right);
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