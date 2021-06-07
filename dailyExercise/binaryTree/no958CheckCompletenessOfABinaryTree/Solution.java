package no958CheckCompletenessOfABinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-06-07 14:01
 */
public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root==null){
            return true;
        }
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int level = 0;

        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                list.add(node);
                if (node==null){
                    continue;
                }
                if (node.left!=null){
                    deque.offerLast(node.left);
                }else {
                    deque.offerLast(null);
                }
                if (node.right!=null){
                    if (node.left==null){
                        return false;
                    }
                    deque.offerLast(node.right);
                }else {
                    deque.offerLast(null);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)==null){
                for (int j = i; j < list.size(); j++) {
                    if (list.get(j)!=null){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
class MySolution{
    public boolean isCompleteTree(TreeNode root) {
        List<ANode> list = new ArrayList<>();
        list.add(new ANode(root,1));
        int i = 0;
        while(i<list.size()){
            ANode aNode = list.get(i++);
            if (aNode.node!=null){
                list.add(new ANode(aNode.node.left,aNode.code*2 ));
                list.add(new ANode(aNode.node.right,aNode.code*2+1));
            }
        }
        return list.get(i-1).code==list.size();
    }
    public boolean test(TreeNode node){
        ANode aNode = new ANode(node,1);
        List<ANode> list = new ArrayList<>();
        list.add(aNode);
        int i = 0;
        while (i<list.size()){
            ANode aNode1 = list.get(i);
            if (aNode1.node!=null){
                list.add(new ANode(aNode1.node.left, aNode.code*2));
                list.add(new ANode(aNode1.node.right,aNode1.code*2+1));
            }
            i++;

        }
        return list.get(i-1).code==list.size();


    }
}
class Solution1{
    int size = 0;
    int maxIndex = 0;
    public boolean isCompleteTree(TreeNode root) {
        if (root==null){
            return true;
        }
        dfs(root,1);
        return size == maxIndex;
    }
    public void dfs(TreeNode node,int index){
        if (node==null){
            return;
        }
        size++;
        maxIndex = Math.max(index,maxIndex);
        dfs(node.left,index*2);
        dfs(node.right,index*2+1);
    }
}
class ANode{
    TreeNode node;
    int code;
    ANode(TreeNode node,int code){
        this.code = code;
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