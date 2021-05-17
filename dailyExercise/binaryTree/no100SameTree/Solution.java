package binaryTree.no100SameTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-14 22:45
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null){
            return true;
        }else if (p==null||q==null){
            return false;
        }else if (p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }


    }
    public boolean process(TreeNode p,TreeNode q){
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue1.push(p);
        queue2.push(q);
        while(!queue1.isEmpty()&&!queue2.isEmpty()){ ;
            TreeNode temp1 = queue1.pollFirst();
            TreeNode temp2 = queue2.pollFirst();
            if (temp1.val==temp2.val){
                if (temp1.left!=null&& temp2.left!=null){
                    queue1.push(temp1.left);
                    queue2.push(temp2.left);
                }else if (temp1.left==null&&temp2.left!=null){
                    return false;
                }else if (temp2.left==null&&temp1.left!=null){
                    return false;
                }
                if (temp2.right!=null&&temp1.right!=null){
                    queue1.push(temp1.right);
                    queue2.push(temp2.right);
                }else if (temp1.right==null&&temp2.right!=null){
                    return false;
                }else if (temp2.right==null&&temp1.right!=null){
                    return false;
                }
            }else{
                return false;
            }
        }
        return queue1.size() == 0 && queue2.size() == 0;
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