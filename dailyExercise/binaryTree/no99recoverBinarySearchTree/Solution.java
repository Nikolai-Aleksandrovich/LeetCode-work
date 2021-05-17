package binaryTree.no99recoverBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-05-14 21:57
 */
public class Solution {
    List<Integer> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        dfs(root);
        int a = -1;
        int b = -1;
        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            if ((list.get(i-1)>=list.get(i))){
                a = i-1;
            }

        }
        for (int i = list.size()-1; i >0 ; i--) {
            if (list.get(i-1)>=list.get(i)){
                b=i;
            }
        }
        System.out.println(a);
        System.out.println(b);
        change(root,a,b);

    }
    public void dfs(TreeNode treeNode){
        if (treeNode==null){
            return;
        }
        dfs(treeNode.left);
        list.add(treeNode.val);
        dfs(treeNode.right);
    }
    public void change(TreeNode treeNode,int a,int b){
        if (treeNode==null){
            return;
        }
        if (treeNode.val == a){
            treeNode.val= b;
        }
        if (treeNode.val==b){
            treeNode.val = a;
        }
        dfs(treeNode.left);
        list.add(treeNode.val);
        dfs(treeNode.right);
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
