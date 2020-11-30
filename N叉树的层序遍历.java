package com.itranswarp.sample;

import org.w3c.dom.Node;

import java.util.*;

public class Solution1 {
    //改进后的迭代思路
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<Node> previousList= Arrays.asList(root);
        while (!previousList.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousVal = new ArrayList<>();
            for (Node node : previousList) {
                previousVal.add(node.val);
                currentLayer.addAll(node.children);
            }
            res.add(previousVal);
            previousList = currentLayer;
        }
        return res;

    }

}


    /**List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i =0;i<size;i++) {
                Node node = queue.remove();//必须的，不然会出错NoSuch...
                level.add(node.val);
                queue.addAll(node.children);
            }
            ans.add(level);
        }
        return ans;
    }
}*/

    /**List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null){
            return list;
        }
        int level = 0;
        helper(root,level);
        return list;

    }
    private void helper(Node root,int level){
        if(list.size()<=level){
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        for (Node child:root.children){
            helper(child,level+1);
        }
     */

    }

}
