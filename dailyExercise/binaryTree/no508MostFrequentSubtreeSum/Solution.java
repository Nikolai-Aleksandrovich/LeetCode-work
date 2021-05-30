package no508MostFrequentSubtreeSum;


import java.util.*;

/**
 * @author Yuyuan Huang
 * @create 2021-05-27 21:57
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。

 */
public class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            }
    );
    List<Integer> list = new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        for (Integer key: map.keySet()) {
            priorityQueue.offer(map.get(key));
        }
        if (priorityQueue.size()==0){
            return new int[0];
        }
        int value = priorityQueue.peek();
        System.out.println(value);
        list.clear();
        for (Integer key: map.keySet()) {
            if (map.get(key)==value){
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;



    }
    public int dfs(TreeNode node){
        if (node==null){
            return 0;
        }
        int value = dfs(node.left)+dfs(node.right)+node.val;
        list.add(value);
        return value;
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