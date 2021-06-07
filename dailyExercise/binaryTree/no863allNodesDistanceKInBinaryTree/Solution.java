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
class MySolution{
    Map<TreeNode,TreeNode> map;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        map = new HashMap<>();
        dfs(root,null);
        for (TreeNode node: map.keySet()
             ) {
            System.out.println(node.val);
            if (map.get(node)!=null){
                System.out.println(map.get(node).val);
            }

        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);
        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList();
                    for (TreeNode n: queue)
                        ans.add(n.val);
                    return ans;

                }
                queue.offer(null);
                dist++;
            }else {
                //先放左，后放右，再放父
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = map.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }


            }


        }
        return new ArrayList<>();

    }
    public void dfs(TreeNode node,TreeNode prev){
        if (node==null){
            return;
        }
        map.put(node,prev);
        dfs(node.left,node);
        dfs(node.right,node);
    }

}
class AnotherSolution{
    List<Integer> ans;
    TreeNode target;
    int K;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode node) {
        if (node == null)
            return -1;
        else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if (L != -1) {
                if (L == K) ans.add(node.val);
                subtree_add(node.right, L + 1);
                return L + 1;
            } else if (R != -1) {
                if (R == K) ans.add(node.val);
                subtree_add(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    public void subtree_add(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K)
            ans.add(node.val);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }



}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }