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

import java.util.*;

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ansList = new ArrayList<>();
        Stack<Node> nodeList = new Stack<>();
        Stack<Node> tempStack = new Stack<>();
        if(root==null) {
            return ansList;
        }
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            Node node = nodeList.pop();
            tempStack.push(node);
            for (Node child : node.children) {
                nodeList.push(child);
            }
        }
        while (!tempStack.isEmpty()) {
            ansList.add(tempStack.pop().val);
        }
        return ansList;


    }
}
        /**我再一次练习递归
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;

    }
    private void dfs(Node root,List<Integer> list){
        if(root==null){
            return;
        }
        for(Node node:root.children) {
            dfs(child, list);
        }
        list.add(root.val);

    }
}*/

        /**思路错误情况下的设想
         *
         * Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack1=new Stack<>();
        List<Integer> ans = new LinkedList<>();
        if(root==null){
            return ans;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            stack1.push(node);
            Collections.reverse(node.children);
            for (Node child : node.children){
                queue.add(child);
            }
        }
        while(!stack1.isEmpty()){
            ans.add(stack1.pop().val);
        }
        return ans;
        */

        /**我想的递归
         * List<Integer> list = new LinkedList<>();
        helper(root,list);
        return list;

    }
    private void helper(Node root,List<Integer> list){
        if(root==null){
            return;
        }
        for (Node child:root.children){
            helper(child,list);
        }
        list.add(root.val);
         */
    }

}