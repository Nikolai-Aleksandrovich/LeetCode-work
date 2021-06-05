package no863allNodesDistanceKInBinaryTree;

import javax.xml.transform.stax.StAXResult;
import java.util.*;

/**
 * @author Yuyuan Huang
 * @create 2021-06-05 20:30
 */
public class Solution {
    Map<TreeNode,TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap();
        //建立子节点对父节点的映射
        dfs(root, null);
        //队列先放入null和目标节点
        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);
        //建立一个set
        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);
        int dist = 0;
        //不断出队入队
        while (!queue.isEmpty()) {
            //出队
            TreeNode node = queue.poll();

            if (node == null) {


                if (dist == K) {
                    List<Integer> ans = new ArrayList();
                    for (TreeNode n : queue)
                        ans.add(n.val);
                    return ans;
                }
                queue.offer(null);
                dist++;

            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }
        return new ArrayList<>();
    }
    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }


}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }