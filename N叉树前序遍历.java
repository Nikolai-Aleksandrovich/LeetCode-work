package com.itranswarp.sample;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.util.*;


class Solution {
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();//为啥这里要用Node？因为这样才能把每次的Nodechildren改编成变化的
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            Collections.reverse(node.children);//123-->321
            for (Node child : node.children) {
                stack.push(child);
            }

        }
        return ans;
    }
}

        /**我自己的方法
         * Stack<Node> stack = new Stack<>();我自己的方法
        LinkedList<Integer> list = new LinkedList<>();
        dfs(root,list);
        return list;

    }
    private void dfs(Node root, LinkedList<Integer> list){
        if(root==null){
            return;
        }
        if(!isEmptyChildren(root)){//这个判断其实不需要，因为即使叶子所有子为空，遍历完也不会加入任何值
            list.add(root.val);
            return;
        }
        list.add(root.val);
        for (Node child:root.children){
            dfs(child,list);
        }

    }
    public boolean isEmptyChildren(Node root){//这里一定要想清楚，到底什么时候是ture，什么时候是false,这个判断其实不需要。
        for (Node child:root.children){
            if (child!=null){
                return true;
            }
        }
        return false;
         */
