package binaryTree.no235lowestCommonAncestorOfABinarySearch;

import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (true){
            if (p.val<node.val&&q.val<node.val){
                node= node.left;
            }else if (p.val>node.val&&q.val>node.val){
                node=node.right;
            }else if ((p.val<node.val&&q.val>node.val)||(q.val<node.val&&p.val>node.val)){
                return node;
            }else if (p.val== node.val||q.val== node.val){
                return node;
            }
        }

    }

}
class MySolution{
    private TreeNode ans;
    public MySolution(){
        this.ans=null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root,p,q);
        return this.ans;

    }
    private boolean dfs(TreeNode node,TreeNode p,TreeNode q){
        if (node==null){
            return false;
        }
        boolean left = dfs(node.left,p,q);
        boolean right = dfs(node.right,p,q);
        if ((left && right) ||(node==p||node==q)&&(left||right)){
            ans = node;
            return true;
        }return left||right||node==p||node==q;
    }

}
class MySolution2 {
    Map<TreeNode,TreeNode> map = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            if (node.left!=null){
                deque.offerLast(node.left);
                map.put(node.left,node);
            }
            if (node.right!=null){
                deque.offerLast(node.right);
                map.put(node.right,node);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        TreeNode temp = p;
        while (temp!=null){
            set.add(temp);
            temp = map.get(temp);

        }
        TreeNode temp1 = q;
        while(!set.contains(temp1)){
            temp1 = map.get(temp1);
        }
        return temp1;
    }


}
class MySolution3{
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }
    public boolean dfs(TreeNode node,TreeNode p,TreeNode q){
        if (node==null){
            return false;
        }
        boolean left = dfs(node.left,p,q);
        boolean right = dfs(node.right,p,q);

        if (right&&left||(right||left)&&(node==p||node==q)){
            ans = node;
            return true;
        }
        return left||right||node==p||node==q;

    }
}
class MySolution4{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        while (true){
            if (root.val> p.val&&root.val>q.val){
                root=root.left;
            }else if (root.val<p.val&&root.val<q.val){
                root=root.right;
            }else if (root.val>p.val&&root.val<q.val||root.val<p.val&&root.val>q.val){
                return root;
            }else {
                return root;
            }
        }
    }
}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}