package binaryTree.no101SynnetricTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-15 9:58
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {

       return check(root.left,root.right);
    }
    private boolean check(TreeNode left,TreeNode right){
        if (left==null&&right==null){
            return true;
        }else if (left==null||right==null){
            return false;
        }

            return  ((left.val == right.val)&&check(left.left,right.right)&&check(left.right,right.left));



    }
    public boolean isSymmetric1(TreeNode root) {
        if (root==null){
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        if (root.left!=null&&root.right!=null){
            if (root.left.val == root.right.val){

                queue.addLast(root.left);
                queue.addLast(root.right);


            }else {
                return false;
            }
        }else if ((root.left==null&&root.right!=null)||(root.right==null&&root.left!=null)){
            return false;
        }


        while (!queue.isEmpty()){
            TreeNode temp1 = queue.pollFirst();
            TreeNode temp2 = queue.pollFirst();
            if (temp1.left!=null&&temp2.right!=null){
                if (temp1.left.val==temp2.right.val){
                    queue.addLast(temp1.left);
                    queue.addLast(temp2.right);
                }else {
                    return false;
                }
            }else if ((temp1.left==null&&temp2.right!=null)||(temp2.right==null&&temp1.left!=null)){
                return false;
            }
            if (temp2.left!=null&&temp1.right!=null){
                if (temp2.left.val==temp1.right.val){
                    queue.addLast(temp2.left);
                    queue.addLast(temp1.right);
                }else {
                    return false;
                }
            }else if ((temp2.left==null&&temp1.right!=null)||(temp1.right==null&&temp2.left!=null)){
                return false;
            }

        }
        return true;
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