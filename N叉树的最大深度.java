package com.itranswarp.sample;

import org.w3c.dom.Node;

import java.util.*;

public class Solution {

    public int maxDepth(Node root) {
        Queue<Pair<Node, Integer>> stack = new LinkedList<Pair<Node, Integer>>();

        if (root == null) {
            return 0;
        }
        int depth = 0;
        stack.add(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair<Node, Integer> current = stack.remove();
            root = current.getKey();
            int currentDepth = current.getValue();
            if (root != null) {
                depth = Math.max(currentDepth, depth);
                for (Node node : root.children) {
                    stack.add(new Pair(node, currentDepth + 1));
                }
            }
        }
        return depth;
    }
}

        /**if(root==null){
            return 0;
        }else if(root.children.isEmpty()){
            return 1;
        }else {
            List<Integer> list = new ArrayList<>();
            for(Node child:root.children){
                list.add(maxDepth(child));
            }
            return Collections.max(list)+1;
        }
    }
}*/
