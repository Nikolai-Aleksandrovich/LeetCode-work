package no513findBottomLeftTreeValue;


/**
 * @author Yuyuan Huang
 * @create 2021-05-27 23:06
 */
public class Solution {
    class Solution {
        int finalVal;
        int maxLevel;
        int base;
        public int findBottomLeftValue(TreeNode root) {
            dfs(root);
            return finalVal;
        }
        private void dfs(TreeNode node){
            if (node==null){
                return;
            }
            base++;
            dfs(node.left);
            update(node,base);
            dfs(node.right);
            base--;
        }
        private void update(TreeNode node,int cruLevel){
            if(cruLevel>maxLevel&&node.left==null&&node.right==null){
                maxLevel = cruLevel;
                finalVal = node.val;
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