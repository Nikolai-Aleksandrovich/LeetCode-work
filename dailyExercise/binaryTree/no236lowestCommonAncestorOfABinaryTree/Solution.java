package binaryTree.no236lowestCommonAncestorOfABinaryTree;


import java.util.*;

/**
 * @author Yuyuan Huang
 * @create 2021-05-22 22:41
 */
public class Solution {
    HashMap<TreeNode,TreeNode> map = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        reverseOrder(root);
        for (TreeNode node :
                map.keySet()) {
            System.out.println("key"+node.val);
            System.out.println("value"+map.get(node).val);
        }
        Set<TreeNode> set = new HashSet<>();
        while (p!=null){
            set.add(p);
            p=map.get(p);
        }
        while (q!=null){
            if (set.contains(q)){
                return q;
            }else {
                q=map.get(q);
            }
        }
        return q;

    }
    private void dfs(TreeNode node){
        if (node==null){
            return;
        }
        if (node.left!=null){
            map.put(node.left,node);
            dfs(node.left);
        }
        if (node.right!=null){
            map.put(node.right,node);
            dfs(node.right);
        }
    }
//    public void reverseOrder(TreeNode node){
//        Deque<TreeNode> deque = new LinkedList<>();
//        TreeNode node1 = node;
//        TreeNode pre = null;
//        while(!deque.isEmpty()||node1!=null){
//            while (node1!=null){
//                deque.push(node1);
//                node1=node1.left;
//            }
//            TreeNode temp = deque.pop();
//            if (temp.right!=null){
//                if (temp.right==pre){
//                    map.put(temp,deque.peek());
//                }else {
//                    deque.push(temp);
//                    node1 = temp.right;
//                }
//
//            }else {
//                if (deque.peek()==null){
//                    map.put(temp,null);
//                }else {
//                    map.put(temp,deque.peek());
//                    pre = temp;
//                }
//
//            }
//
//        }
//    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }