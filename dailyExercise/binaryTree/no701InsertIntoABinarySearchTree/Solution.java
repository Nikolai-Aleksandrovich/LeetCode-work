package no701InsertIntoABinarySearchTree;

/**
 * @author Yuyuan Huang
 * @create 2021-06-04 10:02
 */
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while(pos!=null){
            if (val<pos.val){
                if (pos.left==null){
                    pos.left=new TreeNode(val);
                }else {
                    pos = pos.left;
                }
            }else {
                if (pos.right==null){
                    pos.right = new TreeNode(val);
                }else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if (root==null){
//            return new TreeNode(val);
//        }
//        TreeNode pos = root;
//        while(pos!=null){
//            if (val<pos.val){
//                if (pos.left==null){
//                    pos.left = new TreeNode(val);
//                    return root;
//                }else {
//                    pos= pos.left;
//                }
//            }else {
//                if (pos.right == null){
//                    pos.right  = new TreeNode(val);
//                    return root;
//                }else {
//                    pos = pos.right;
//                }
//            }
//        }
//        return root;
//    }
//}
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