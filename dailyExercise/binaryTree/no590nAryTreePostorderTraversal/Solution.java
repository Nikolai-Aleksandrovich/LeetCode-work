package binaryTree.no590nAryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-04-22 19:54
 */
public class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        dfs(root);
        return list;
    }
    private void dfs(Node root){
        if (root!=null){
            for (Node node:root.children
                 ) {
                dfs(node);
                list.add(node.val);
            }
        }

    }
    private List<Integer> bfs(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null){
            return output;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node item :
                    node.children) {
                stack.push(item);
            }
        }
        return output;
    }
}
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