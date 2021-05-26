package binaryTree.no449serializeAndDeserializeBst;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-05-24 14:22
 */
public class Solution {
    // Encodes a tree to a single string.
    public StringBuilder preSerialize(TreeNode node,StringBuilder str){
        if (node == null){
            return str;
        }
        preSerialize(node.left,str);
        preSerialize(node.right,str);
        str.append(node.val);
        str.append(",");
        return str;
    }

    public String serialize(TreeNode root) {
        return preSerialize(root,new StringBuilder()).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataList = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(dataList));
        return innerDeserialize(list);
    }
    public TreeNode innerDeserialize(List<String> data){
        if (data.get(0).equals("N")){
            data.remove(0);
            return null;
        }
    }
    public TreeNode buildTree(List<String> list){


    }
    private TreeNode helper(List<String> list)
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}