package no662MaximumWidthOfBinaryTree;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Yuyuan Huang
 * @create 2021-06-02 14:49
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 */
public class Solution {
    int ans;
    Map<Integer,Integer> left;
    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap<>();
        dfs(root,0,0);
        return ans;

    }
    public void dfs(TreeNode root,int depth,int pos){
        if (root==null){
            return;
        }
        left.computeIfAbsent(depth,x->pos);
        ans = Math.max(ans,pos-left.get(depth)-1);
        dfs(root.left,depth+1,2*pos);
        dfs(root.right,depth+1,2*pos+1);
    }
    public int width(TreeNode root){
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root,0,0));
        int curDepth = 0,left = 0,ans = 0;
        while (!queue.isEmpty()){
            AnnotatedNode a = queue.poll();
            if (a.node!=null){
                queue.add(new AnnotatedNode(a.node.left,a.depth+1,2*a.pos));
                queue.add(new AnnotatedNode(a.node.right,a.depth+1,2*a.pos+1));
                if (curDepth!=a.depth){
                    curDepth=a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans,a.pos-left+1);
            }
        }
        return ans;

    }

}

class AnnotatedNode{
    TreeNode node;
    int depth,pos;
    AnnotatedNode(TreeNode n,int d,int p){
        node = n;
        depth = d;
        pos = p;
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