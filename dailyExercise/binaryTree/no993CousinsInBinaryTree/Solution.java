package no993CousinsInBinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-06-12 22:01
 */
public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root==null){
            return false;
        }
        Deque<NodeAndFather> deque = new LinkedList<>();
        deque.offerLast(new NodeAndFather(root,null));
        while(!deque.isEmpty()){
            int size = deque.size();
            List<NodeAndFather> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NodeAndFather element = deque.pollFirst();
                list.add(element);
                if (element.node.left!=null){
                    deque.offerLast(new NodeAndFather(element.node.left,element.node));
                }
                if (element.node.right!=null){
                    deque.offerLast(new NodeAndFather(element.node.right,element.node));
                }
            }
            TreeNode temp1 = null;
            boolean flag1 = false;
            TreeNode temp2 = null;
            boolean flag2 = false;
            for (NodeAndFather element:list
                 ) {
                if (element.node.val ==x){
                    temp1 = element.father;
                    flag1 = true;
                }
                if (element.node.val==y){
                    temp2 = element.father;
                    flag2 = true;
                }
            }
            if (temp1 !=temp2&&flag1&&flag2){
                return true;
            }
        }
        return false;

    }
}
class NodeAndFather{
    TreeNode node;
    TreeNode father;
    public NodeAndFather(TreeNode node,TreeNode father){
        this.father = father;
        this.node = node;
    }
}
class Solution1 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root==null){
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode element = deque.pollFirst();
                if (element==null){
                    list.add(0);
                    continue;
                }else {
                    list.add(element.val);
                }
                if (element.left!=null){
                    deque.offerLast(element.left);
                }else {
                    deque.offerLast(null);
                }
                if (element.right!=null){
                    deque.offerLast(element.right);
                }else {
                    deque.offerLast(null);
                }
            }
            int indexX = list.indexOf(x);
            int indexY = list.indexOf(y);
            if (list.contains(x)&& list.contains(y)){
                if (list.indexOf(x)!=list.indexOf(y)+1&&list.indexOf(y)!=list.indexOf(x)+1){
                    return true;
                }else {
                    int min = Math.min(indexX,indexY);
                    int max = Math.max(indexX,indexY);
                    if (min%2==1&&max%2==0&&max-min==1){
                        return true;
                    }
                }
            }
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