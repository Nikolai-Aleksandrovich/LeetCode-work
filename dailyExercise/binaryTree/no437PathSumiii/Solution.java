package binaryTree.no437PathSumiii;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-05-23 22:49
 */
public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0,1);
        int curSum = 0;
        return recursionPathSum(root,prefixSumCount,targetSum,curSum);

    }
    private int recursionPathSum(TreeNode node,Map<Integer,Integer> prefixSumCount,int target,int currSum){
        if (node==null){
            return 0;
        }
        int res = 0;

        currSum += node.val;

        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixSumCount.getOrDefault(currSum - target, 0);
        prefixSumCount.put(currSum, prefixSumCount.get(currSum)+1);
        res+=recursionPathSum(node.left,prefixSumCount,target,currSum);
        res+=recursionPathSum(node.right,prefixSumCount,target,currSum);
        prefixSumCount.put(currSum,prefixSumCount.get(currSum)-1);
        return res;

    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,Integer> map = new HashMap<>();
        if (root==null){
            return 0;
        }
        map.put(0,1);
        return helper(root,map,targetSum,0)


    }
    private int helper(TreeNode node,Map<Integer,Integer> map,int target,int curSum){
        if (node==null){
            return 0;
        }
        int res = 0;
        curSum+= node.val;
        res+=map.getOrDefault(curSum-target,0);
        map.put(curSum, map.get(curSum)+1);
        res+=helper(node.left,map,target,curSum);
        res+=helper(node.right,map,target,curSum);

        map.put(curSum, map.get(curSum)-1);
        return res;
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
