package no543diameterOfBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-05-28 15:57
 */
public class Solution {
    HashMap<TreeNode,Integer> lengthMap = new HashMap<>();
    HashMap<TreeNode,Integer> contributeLMap = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        int maxVal = 0;
        for(TreeNode node: lengthMap.keySet()){
            System.out.println("s");
            System.out.println(node.val);
            System.out.println(lengthMap.get(node));
            System.out.println("e");
            maxVal = Math.max(maxVal,lengthMap.get(node));
        }
        for(TreeNode node: contributeLMap.keySet()){
            System.out.println("s1");
            System.out.println(node.val);
            System.out.println(contributeLMap.get(node));
            System.out.println("e1");

        }
        return maxVal-1;
    }
    private void dfs(TreeNode node){
        if (node==null){
            return;
        }
        dfs(node.left);
        int maxLeft = contributeLMap.getOrDefault(node.left,0);
        int maxRight = contributeLMap.getOrDefault(node.right,0);
        System.out.println(node.val);
        System.out.println(maxLeft);
        System.out.println(maxRight);
        if(node.left==null&&node.right==null){
            lengthMap.put(node,0);
            contributeLMap.put(node,1);
        }else {
            lengthMap.put(node,maxLeft+maxRight+1);
            contributeLMap.put(node,Math.max(maxLeft,maxRight)+1);
        }
        dfs(node.right);
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

            s
          2
          0
          e
          s
          3
          0
          e
          s
          1
          2
          e
          s1
          2
          1
          e1
          s1
          3
          1
          e1
          s1
          1
          2
          e1


