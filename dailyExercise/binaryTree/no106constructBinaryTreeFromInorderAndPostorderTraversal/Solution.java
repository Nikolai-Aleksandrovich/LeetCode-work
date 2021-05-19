package binaryTree.no106constructBinaryTreeFromInorderAndPostorderTraversal;


import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-05-18 15:44
 */
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder==null||inorder.length==0||inorder.length!= postorder.length){
            return null;
        }
        for (int i = 0; i < postorder.length; i++) {
            map.put(inorder[i],i );
        }
        int n = inorder.length;
        return myBuildTree(inorder,postorder,0,n-1,0,n-1);


    }
    private TreeNode myBuildTree(int[] inorder,int[] postorder,int inorderLeft,int inorderRight,int postorderLeft,int postorderRight){
        System.out.println(inorder[inorderLeft]);
        System.out.println(inorder[inorderRight]);
        System.out.println(postorder[postorderLeft]);
        System.out.println(postorder[postorderRight]);
        if (postorderLeft>postorderRight){
            return null;
        }
        int rootValue = postorder[postorderRight];
        int inorderRootIndex = map.get(rootValue);
        int leftTreeSize = inorderRootIndex-inorderLeft;
        int rightTreeSize = inorderRight-inorderRootIndex;
        TreeNode root = new TreeNode(rootValue);
        root.left = myBuildTree(inorder,postorder,inorderLeft,inorderLeft+leftTreeSize-1,postorderLeft,postorderLeft+leftTreeSize-1);

        root.right = myBuildTree(inorder,postorder,inorderRootIndex+1,inorderRight,postorderLeft+leftTreeSize,postorderRight-1);
        return root;
    }
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder==null||inorder.length==0){
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        stack.push(root);
        int inorderIndex = inorder.length-1;
        for (int i = postorder.length-2; i >=0 ; i--) {
            int postorderValue=postorder[i];

            TreeNode node = stack.peek();
            if (node.val!=inorder[inorderIndex]){
                TreeNode temp = new TreeNode(postorderValue);
                node.right = temp;
                stack.push(temp);

            }else {
//                TreeNode = inorderIndex;

                while(!stack.isEmpty()&&inorder[inorderIndex]==stack.peek().val){
                    node = stack.pop();
                    inorderIndex--;
                }
                TreeNode incoming = new TreeNode(postorderValue);
                node.left = incoming;
                stack.push(incoming);
            }
        }
        return root;
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
