package binaryTree.no199BinaryTreeRightSideView;


import java.util.*;

/**
 * @author Yuyuan Huang
 * @create 2021-05-22 20:11
 */
public class Solution {
    List<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        return rightView;
    }
    public List<Integer> rightSideView1(TreeNode root){
        Map<Integer,Integer> map = new HashMap<>();
        int maxDepth = -1;
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> valueQueue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        nodeQueue.push(root);
        valueQueue.push(0);
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.pop();
            int curDepth = valueQueue.pop();
            if (node.left!=null){
                nodeQueue.push(node.left);
                valueQueue.push(curDepth+1);
            }
            if (node.right!=null){
                nodeQueue.push(node.right);
                valueQueue.push(curDepth+1);
            }
            if (!map.containsKey(curDepth)){
                map.put(curDepth,node.val);
            }
        }
        int size = map.size();
        for (int i = 0; i < size; i++) {
            list.add(map.get(i));
        }

        return list;

    }
    public List<Integer> rightSideView2(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        deque.offerLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {

                TreeNode node = deque.pollFirst();
                if (node.left!=null){
                    deque.offerLast(node.left);
                    System.out.println(node.left.val);
                }
                if (node.right!=null){
                    deque.offerLast(node.right);
                    System.out.println(node.right.val);
                }
                if (i==size-1){
                    list.add(node.val);
                }
            }

        }
        return list;
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
