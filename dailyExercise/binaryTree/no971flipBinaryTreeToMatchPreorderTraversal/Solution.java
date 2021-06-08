package no971flipBinaryTreeToMatchPreorderTraversal;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-06-07 16:33
 */
public class Solution {
    int index;
    int[] voyage;
    List<Integer> list;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root==null&&voyage==null){
            return null;
        }
        this.voyage = voyage;
        list = new ArrayList<>();
        dfs(root);
        if (!list.isEmpty()&&list.get(0)==-1){
            list.clear();
            list.add(-1);
        }
        return list;

    }
    public void dfs(TreeNode node){
        if (node != null){
            if (node.val!=voyage[index++]){
                list.clear();
                list.add(-1);
                return;
            }
            //索引合法&&左不为空&& 左值不合法
            if (index < voyage.length && node.left != null && node.left.val != voyage[index]) {
                list.add(node.val);
                dfs(node.right);
                dfs(node.left);
            }else {
                dfs(node.left);
                dfs(node.right);
            }
        }


    }
}
class MySolution{
    int[] voyage;
    int index;
    List<Integer> list;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        list = new ArrayList<>();
        this.voyage = voyage;
        dfs(root);
        if (list.contains(-1)){
            list.clear();
            list.add(-1);
        }
        return list;
    }
    public void dfs(TreeNode node){
        if (node!=null){
            if (node.val!=voyage[index++]){
                list.clear();
                list.add(-1);
            }
            if (node.left!=null&&index< voyage.length&&node.left.val!=voyage[index]){
                list.add(node.val);
                dfs(node.right);
                dfs(node.left);
            }else {
                dfs(node.left);
                dfs(node.right);
            }

        }
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