package binaryTree.no235lowestCommonAncestorOfABinarySearch;

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

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}