package no889constructBinaryTreeFromPreorderAndPostorderTraversal;

import java.util.HashMap;

/**
 * @author Yuyuan Huang
 * @create 2021-06-05 11:52
 */
public class Solution {
    HashMap<Integer,Integer> map;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i],i);
        }
        return buildTree(pre,post,0, pre.length-1, 0, post.length-1);


    }
    public TreeNode buildTree(int[] pre,int[] post,int preLeft,int preRight,int postLeft,int postRight){
        System.out.println(preLeft);
        System.out.println(preRight);
        if (preLeft>preRight){
            return null;
        }
        if (preLeft==preRight){
            return new TreeNode(pre[preLeft]);
        }
        int root = pre[preLeft];
        TreeNode node = new TreeNode(root);
        int nextMidValue = pre[preLeft+1];

        int leftTreeSize = map.get(nextMidValue)-postLeft+1;

        int rightTreeSize = preRight-preLeft-leftTreeSize;

        node.left = buildTree(pre,post,preLeft+1,preLeft+leftTreeSize,postLeft,postLeft+leftTreeSize-1);
        node.right = buildTree(pre,post,preRight-rightTreeSize+1,preRight,postRight-rightTreeSize,postRight-1);
        return node;


    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }