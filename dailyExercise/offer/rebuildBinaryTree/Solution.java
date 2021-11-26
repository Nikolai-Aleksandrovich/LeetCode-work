package offer.rebuildBinaryTree;


import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-07-26 19:24
 */
public class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i],i);
        }
        return dfs(preorder,inorder,0, preorder.length-1,0, inorder.length-1 );
    }
    public TreeNode dfs(int[] preorder,int[] inorder,int preStart,int preEnd,int inStart,int inEnd){


        int root = preorder[preStart];
        int rootIndexInIn = map.get(root);
        TreeNode rootNode = new TreeNode(root);
        int leftTreeSize = rootIndexInIn-inStart;
        int rightTreeSize = inEnd - rootIndexInIn;
        if (leftTreeSize>0){
            rootNode.left = dfs(preorder,inorder,preStart+1,preStart+leftTreeSize,inStart,rootIndexInIn-1);
        }
        if (rightTreeSize>0){
            rootNode.right = dfs(preorder,inorder,preStart+1+leftTreeSize,preEnd,inStart+1+leftTreeSize,inEnd);
        }
        return rootNode;


    }
}
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value){
        this.value = value;
    }
}
