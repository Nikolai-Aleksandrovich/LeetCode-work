package binaryTree.no105constructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-05-15 14:51
 */
public class Solution {
    private Map<Integer,Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }
    private TreeNode myBuildTree(int[] preorder,int[] inorder
            ,int preorderLeft,int preorderRight
            ,int inorderLeft,int inorderRight){
        if (preorderLeft>preorderRight){
            return null;
        }
        //前序遍历的第一个节点就是根节点
        int preorderRoot = preorderLeft;
        //在中序遍历中定位根节点
        int inorderRoot = indexMap.get(preorder[preorderRoot]);
        //构造根节点
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        //左子树的节点数目
        int sizeLeftSubTree = inorderRoot-inorderLeft;
        //递归构造子树，连接到根节点
        //先序遍历中 从左边界+1开始的sizeLeftSubtree个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.right = myBuildTree(preorder,inorder,preorderLeft+1,
                preorderLeft+sizeLeftSubTree,inorderLeft,
                inorderRoot-1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder,inorder,preorderLeft+sizeLeftSubTree+1,
                preorderRight,inorderRoot+1,inorderRight);
        return root;
    }
    private TreeNode myBuildTree1(int[] preorder,int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight){
        int preorderRootIndex = preorderLeft;
        int inorderRootIndex = indexMap.get(preorder[preorderRootIndex]);
        int inorderRootValue = preorder[preorderRootIndex];
        TreeNode node = new TreeNode(inorderRootValue);
        int leftTreeSize =inorderRootIndex-inorderLeft;
        node.left = myBuildTree1(preorder,inorder,preorderRootIndex+1,preorderRootIndex+leftTreeSize,inorderLeft,inorderRootIndex-1);
        int rightTreeSize = inorderRight-inorderRootIndex;
        node.right = myBuildTree1(preorder,inorder,preorderRight-rightTreeSize+1,preorderRight,inorderRootIndex+1,inorderRight);
        return node;
    }

    public TreeNode buildTree1(int[] preorder,int[] inorder){
        if (preorder.length!= inorder.length){
            return null;
        }
        for (int i = 0; i < preorder.length; i++) {
            indexMap.put(preorder[i],i);
        }
        return myBuildTree1(preorder,inorder,0, preorder.length-1,0, preorder.length-1 );



    }
    public TreeNode buildTree2(int[] preorder,int[] inorder){
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i );
        }

    }
    private TreeNode buildTree2(int[] preorder,int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight){
        int rootValue = preorder[preorderLeft];
        int inorderRootIndex = indexMap.get(rootValue);
        int leftTreeSize = inorderRootIndex-inorderLeft;
        int rightTreeSize = inorderRight-inorderRootIndex;
        TreeNode node = new TreeNode()

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