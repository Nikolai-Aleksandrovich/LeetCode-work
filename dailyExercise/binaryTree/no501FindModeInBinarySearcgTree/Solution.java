package no501FindModeInBinarySearcgTree;


import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-05-27 21:02
 */
public class Solution {
    List<Integer> answer = new ArrayList<>();
    int value,count,maxCount;
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;

    }
    private void dfs(TreeNode node){
        if (node==null){
            return;
        }
        dfs(node.left);
        update(node.val);
        dfs(node.right);
    }
    private void update(int curVal){
        if (curVal==value){
            count++;
        }else {
            count=1;
            value = curVal;
        }
        if (count==maxCount){
            answer.add(value);
        }else if (count>maxCount){
            maxCount = count;
            answer.clear();
            answer.add(value);
        }

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