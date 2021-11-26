package offer.rebuildBinaryTree.SymBT;


import org.w3c.dom.Node;

/**
 * @author Yuyuan Huang
 * @create 2021-07-26 21:36
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return dfs(root);
    }
    public boolean dfs(TreeNode node){
        if (isSymInUnit(node)){
            return dfs(node.left)&&dfs(node.right);
        }
        return false;
    }
    public boolean isSymInUnit(TreeNode treeNode){
        if (treeNode==null){
            return true;
        }
        if (treeNode.left==null&&treeNode.right==null){
            return true;
        }
        if (treeNode.left==null||treeNode.right==null){
            return false;
        }
        return treeNode.left.val == treeNode.right.val;

    }
}
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution1 {

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
class MySolution{
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    public boolean recur(TreeNode left,TreeNode right){
        if (left==null&&right==null){
            return true;
        }
        if (left==null||right==null||left.val!=right.val){
            return false;
        }
        return recur(left.right,right.left)&&recur(left.left,right.right);
    }
}