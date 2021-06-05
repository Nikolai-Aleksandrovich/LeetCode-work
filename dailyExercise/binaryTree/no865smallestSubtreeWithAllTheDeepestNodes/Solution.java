package no865smallestSubtreeWithAllTheDeepestNodes;

import com.sun.source.tree.Tree;

import java.util.HashMap;

/**
 * @author Yuyuan Huang
 * @create 2021-06-05 16:43
 */
public class Solution {
    HashMap<TreeNode, Integer> depth;
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap<>();
        depth.put(null, -1);
        //首先先序遍历，对每个结点赋予一个深度
        dfs(root, null);
        maxDepth = -1;
        //取得最大深度
        for (Integer d: depth.values())
            maxDepth = Math.max(maxDepth, d);
        //求最大深度对应的父节点
        return answer(root);


    }
    public void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            depth.put(node, depth.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public TreeNode answer(TreeNode node) {
        //如果节点为空，直接返回空，或者已经到达最大节点，返回本节点
        if (node == null || depth.get(node) == maxDepth)
            return node;
        //不然，就对左右节点进行搜索
        TreeNode L = answer(node.left),
                R = answer(node.right);
        //左右子树后代中都有最深节点
        if (L != null && R != null) return node;
        //左子树右子树只有一个有最深节点
        if (L != null) return L;
        if (R != null) return R;

        return null;
    }

}
class MySolution{
    HashMap<TreeNode,Integer> depthMap;
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depthMap = new HashMap<>();
        depthMap.put(null,-1);
        dfs(root,null);
        for (Integer value :depthMap.values()
             ) {
            maxDepth = Math.max(maxDepth,value);
        }
        return findResult(root);
    }
    public void dfs(TreeNode node,TreeNode prev){
        if (node!=null){
            depthMap.put(node,depthMap.get(prev)+1);
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }
    public TreeNode findResult(TreeNode root){
        if (root==null||depthMap.get(root)==maxDepth){
            return root;
        }
        TreeNode left = findResult(root.left);
        TreeNode right = findResult(root.right);
        if (left!=null&&right!=null){
            return root;
        }
        if (left!=null){
            return left;
        }
        return right;

    }
}
class AnotherSolution{
    ResultSet resultSet;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        resultSet = new ResultSet(-1,null);

    }
    public ResultSet dfs(TreeNode node){
        if (node==null){
            return new ResultSet(0,null);
        }
        ResultSet left = dfs(node.left);
        ResultSet right = dfs(node.right);
        if (left.level< right.level){
            return new ResultSet(right.level, node.right);
        }
        if (left.level> right.level){
            return new ResultSet(left.level,node.left);
        }
        return new ResultSet(left.level+1,node);

    }
}
class ResultSet{
    int level;
    TreeNode node;
    public ResultSet(int level,TreeNode node){
        this.level = level;
        this.node = node;
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