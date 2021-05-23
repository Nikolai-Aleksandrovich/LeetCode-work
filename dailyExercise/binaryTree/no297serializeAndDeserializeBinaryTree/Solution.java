package binaryTree.no297serializeAndDeserializeBinaryTree;


import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-05-23 0:17
 */
public class Solution {
    public String rserialize(TreeNode root, String str) {
        if (root==null){
            str=str+"None";
        }else {
            str= str+ String.valueOf(root.val)+",";
            str = rserialize(root.left,str);
            str = rserialize(root.right,str);
        }
        return str;
    }
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }
    public TreeNode rdeserialize(List<String> l) {

    }

}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}