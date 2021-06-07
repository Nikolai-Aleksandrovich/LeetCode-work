package no951FlipEquivalentBinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-06-07 13:25
 */
public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //如果二叉树 root1，root2 根节点值相等，那么只需要检查他们的孩子是不是相等就可以了。
        if(root1==root2){
            return true;
        }
        //如果 root1，root2 的值不相等，那这两个二叉树的一定不等价。
        if (root1==null||root2==null|| root1.val!= root2.val){
            return false;
        }
        return (flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right))||flipEquiv(root1.left,root2.right)&&flipEquiv(root1.right,root2.left);

    }
}
class MySolution{
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        if (list1.size()!=list2.size()){
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }
    public void dfs(TreeNode node, List<Integer> vals) {
        if (node!=null){
            //先添加值
            vals.add(node.val);
            //再取出左右值，判断应该先放左还是先放右
            int left = node.left!=null? node.left.val:-1;
            int right = node.right!=null? node.right.val:-1;
            if (left<right){
                dfs(node.left,vals);
                dfs(node.right,vals);
            }else {
                dfs(node.right,vals);
                dfs(node.left,vals);
            }
            vals.add(null);
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