package no652FindDuplicateSubTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-05-31 21:00
 */
public class Solution {
    Map<String,Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        ans = new ArrayList<>();
        collect(root);
        return ans;


    }
    public String collect(TreeNode node){
        if (node == null){
            return "#";
        }
        String serial = node.val+','+collect(node.left)+','+collect(node.right);
        count.put(serial,count.getOrDefault(serial,0)+1);
        if (count.get(serial)==2){
            ans.add(node);
        }
        return serial;
    }

}
class MySolution{
    Map<String,Integer> map;
    List<TreeNode> list;
    public List<TreeNode>  findDuplicateSubtrees(TreeNode root){
        map = new HashMap<>();
        list = new ArrayList<>();
        helper(root);
        return list;
    }
    public String helper(TreeNode node){
        if (node == null){
            return "#";
        }
        String s = node.val+","+helper(node.left)+','+helper(node.right);
        map.put(s,map.getOrDefault(s,0)+1);
        if (map.get(s)==2){
            list.add(node);
            map.put(s,map.get(s)-1);
        }
        return s;
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