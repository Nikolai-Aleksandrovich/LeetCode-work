package no623AddOneRowToTree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-05-29 17:05
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth==1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int level = 0;
        while(!deque.isEmpty()){
            level++;
            int size = deque.size();
            if (level>depth){
                break;
            }
            for (int i = 0; i < size; i++) {
                System.out.println(level);
                TreeNode node = deque.pollFirst();
                System.out.println(node.val);
                if (node.left!=null){
                    deque.offer(node.left);
                    TreeNode left = node.left;
                    System.out.println("level"+level);
                    System.out.println("depth-1"+(depth-1));
                    if (level==depth-1){
                        System.out.println("yes");
                        System.out.println(node.left.val);
                        node.left=new TreeNode(val);
                        node.left.left = left;
                    }
                }
                if (node.right!=null){
                    deque.offer(node.right);
                    TreeNode right = node.right;
                    if (level==depth-1){
                        node.right=new TreeNode(val);
                        node.right.right = right;
                    }
                }
                if (node.left==null&&node.right==null&&level==depth-1){
                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);
                }
            }

        }
        return root;
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