package no1008constructBinarySearchTreeFromPreorderTraversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-06-13 10:22
 */
public class Solution {
    Map<Integer,Integer> map;
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] original = new int[preorder.length];
        for (int i = 0; i < preorder.length; i++) {
            original[i] = preorder[i];
        }
        Arrays.sort(preorder);
        map = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            map.put(preorder[i],i);
        }
        return buildTree(original,preorder,0, preorder.length-1
                ,0, preorder.length-1);


    }
    public TreeNode buildTree(int[] preorder,int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight){
        if (preorderLeft>preorderRight){
            return null;
        }
        if (preorderLeft==preorderRight){
            return new TreeNode(preorder[preorderLeft]);
        }


        int rootValue = preorder[preorderLeft];
        int rootIndexInInorder = map.get(rootValue);
        int leftTreeSize = rootIndexInInorder-inorderLeft;
        int rightTreeSize = inorderRight-rootIndexInInorder;
        TreeNode node = new TreeNode(rootValue);
        node.left = buildTree(preorder,inorder,preorderLeft+1,
                preorderLeft+leftTreeSize,inorderLeft,inorderLeft+leftTreeSize-1);
        node.right = buildTree(preorder,inorder,preorderRight-rightTreeSize+1,preorderRight,inorderRight-rightTreeSize+1,inorderRight);
        return node;
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
    //二分查找，而不用遍历查找
    class Solution1{
        public TreeNode bstFromPreorder(int[] preorder){
            int len = preorder.length;
            if (len == 0){
                return null;
            }
            return dfs(preorder,0, preorder.length-1);
        }
        //根据左右区间构建二叉树
        private TreeNode dfs(int[] preorder,int left,int right){
            //如果左区间索引大于右区间，说明越界
            if (left>right){
                return null;
            }
            //发现根节点
            TreeNode node = new TreeNode(preorder[left]);
            //区间只有一个节点
            if (left == right){
                return node;
            }
            int l = left;
            int r = right;
            //在区间内进行二分查找
            while(l<r){
                int mid = l+(r-l+1)/2;
                if (preorder[mid]<preorder[left]){
                    l = mid;
                }else {
                    r = mid -1;
                }
            }
            TreeNode leftTree = dfs(preorder,left+1,l);
            TreeNode rightTree = dfs(preorder,l+1,right);
            node.left = leftTree;
            node.right = rightTree;
            return node;
        }

    }
}