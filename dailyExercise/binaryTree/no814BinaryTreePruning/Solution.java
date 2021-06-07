package no814BinaryTreePruning;

/**
 * @author Yuyuan Huang
 * @create 2021-06-05 22:54
 */
public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        dfs(new ResultType(1,root,new TreeNode(-1),1));
        return root;
    }
    public void dfs(ResultType resultType){
        if (resultType.node!=null){

            dfs(new ResultType(1,resultType.node.left,resultType.node,1));
            dfs(new ResultType(0,resultType.node.right,resultType.node,1));
            if (resultType.node.val==0&&resultType.leftColor==1&&resultType.rightColor==1){
                resultType.setColor(0);
                if (resultType.isLeft==1){
                    resultType.prev.left=null;
                }else {
                    resultType.prev.right=null;
                }
            }
        }
    }
}
class ResultType{
    int isLeft;
    int color;
    int leftColor;
    int rightColor;
    TreeNode node;
    TreeNode prev;

    public ResultType(int isLeft,TreeNode node,TreeNode prev,int color){
        this.color = color;
        this.isLeft = isLeft;
        this.node = node;
        this.prev = prev;
    }
    public void setLeftColor(int leftColor){
        this.leftColor = leftColor;
    }
    public void setRightColor(int rightColor){
        this.rightColor = rightColor;
    }
    public void setColor(int color){
        this.color = color;
    }
}
class MySolution{
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root)? root:null;
    }
    public boolean containsOne(TreeNode node){
        //如果节点为空，返回false
        if (node == null){
            return false;
        }
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        if (!a1){
            node.left=null;
        }
        if (!a2){
            node.right=null;
        }
        return node.val == 1||a1||a2;
    }
}
class MySolution1{
    public TreeNode pruneTree(TreeNode root) {
        return judge(root)? null:root;

    }
    public boolean judge(TreeNode node){
        if (node==null){
            return true;
        }
        boolean left = judge(node.left);
        boolean right = judge(node.right);

        if (left&&right){
            node.left=null;
            node.right = null;
            return node.val == 0;
        }
        else if (left){
            node.left=null;
            return false;
        }
        else if (right){
            node.right = null;
            return false;
        }
        return false;

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
