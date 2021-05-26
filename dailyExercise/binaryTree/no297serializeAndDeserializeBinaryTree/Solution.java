package binaryTree.no297serializeAndDeserializeBinaryTree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        if (l.get(0).equals("None")){
            l.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        node.left = rdeserialize(l);
        node.right = rdeserialize(l);
        return node;
    }

    public TreeNode deserialize(String data){
        String[] dataArray = data.split(",");
        List<String> list = new ArrayList<String>(Arrays.asList(dataArray));
        return rdeserialize(new ArrayList<String>(list));
    }

}
class MySerialize{


        public String preSerialize(TreeNode node,String str){
            if (node==null){
                str+="None,";
                return str;
            }
            str= str+node.val+",";
            str += preSerialize(node.left,str);
            str += preSerialize(node.right,str);
            return str;
        }
        public String serialize(TreeNode root){
            return preSerialize(root,"");
        }
        public TreeNode reSerialize(List<String> list){

            if (list.get(0).equals("None")){
                list.remove(0);
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
            list.remove(0);
            node.left = reSerialize(list);
            node.right = reSerialize(list);
            return node;

        }
        public TreeNode deserialize(String s){
            System.out.println(s);
            String[] sList = s.split(",");
            List<String> list =new LinkedList<>( Arrays.asList(sList));
            return reSerialize(list);
        }}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}