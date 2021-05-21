package binaryTree.no113pathSum;

import java.util.*;

/**
 * @author Yuyuan Huang
 * @create 2021-05-21 21:34
 */
public class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    Deque<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return ans;
    }
    private void dfs(TreeNode root,int targetSum){
        if (root==null){
            return;
        }
        list.offer(root.val);
        targetSum = targetSum-root.val;
        if (root.left==null&&root.right==null&&targetSum==0){
            ans.add(new LinkedList<Integer>(list));
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        list.poll();
    }

    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        dfs1(root,targetSum);
        return ans;
    }
    private void dfs1(TreeNode root,int targetSum){
        if (root==null){
            return;
        }
        list.addLast(root.val);
        targetSum=targetSum-root.val;
        if (root.left==null&&root.right==null&&targetSum==0){
            ans.add(new LinkedList<>(list));
        }
        dfs1(root.left,targetSum);
        dfs1(root.right,targetSum);
        list.pollLast();
    }
    List<List<Integer>> ans1 = new LinkedList<>();
    Map<TreeNode,TreeNode> map = new HashMap<>();
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        if (root==null){
            return ans1;
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> valueQueue = new LinkedList<>();
        nodeQueue.push(root);
        map.put(root,null);
        valueQueue.push(root.val);
        while(!nodeQueue.isEmpty()){
            TreeNode temp = nodeQueue.pollFirst();
            int value = valueQueue.pollFirst();
            if (temp.left==null&&temp.right==null){
                if (value == sum){
                    TreeNode findFather = temp;
                    Deque<Integer> list = new LinkedList<>();
                    while (map.get(findFather)!=null){
                        list.addFirst(findFather.val);
                        findFather = map.get(findFather);
                    }
                    list.addFirst(root.val);
                    ans1.add(new LinkedList<>(list));
                }
            }
            if (temp.left!=null){
                map.put(temp.left,temp);
                nodeQueue.push(temp.left);
                valueQueue.push(value+ temp.left.val);
            }
            if (temp.right!=null){
                map.put(temp.right,temp);
                nodeQueue.push(temp.right);
                valueQueue.push(value+ temp.right.val);
            }
        }
        return ans1;
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