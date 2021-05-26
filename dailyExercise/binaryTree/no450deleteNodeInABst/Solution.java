package binaryTree.no450deleteNodeInABst;



/**
 * @author Yuyuan Huang
 * @create 2021-05-24 14:54
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return null;
        }

        TreeNode node = search(root,key);
        TreeNode temp = node;
        if (temp.left!=null){
            while(temp.left!=null){
                temp = temp.left;
            }
            node = temp;
            temp=null;
        }else if (temp.right!=null){
            temp = temp.right;
            return root;
        }else {
            temp=null;
            return root;
        }
        sink(node);
        return root;



    }
    private TreeNode search(TreeNode node,int key){
        if (node==null){
            return null;
        }
        TreeNode temp;
        if (node.val<key){
            return search(node.right,key);
        }else if (node.val>key){
            return search(node.left,key);
        }else {
            return node;
        }

    }
    private void sink(TreeNode node){
        if (node.val>node.left.val){
            TreeNode temp = node;
            node = node.left;
            node.left = temp;
        }
    }
    private TreeNode findPredecessor(TreeNode node){
        if (node==null){
            return null;
        }
        node = node.left;
        if (node.right==null){
            TreeNode out = node;
            node=null;
            return out;
        }
        TreeNode pre = node;
        while(node.right!=null){
            pre = node;
            node = node.right;
        }
        pre.right=null;
        return node;
    }
    private TreeNode findSuccessor(TreeNode node){
        if (node==null){
            return null;
        }
        node = node.right;
        TreeNode pre = node;
        while(node.left!=null){
            pre = node;
            node = node.left;
        }
        pre.left=null;
        return node;
    }
    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root==null){
            return null;
        }
        TreeNode node = search(root,key);
        if (node.left==null&&node.right==null){
            node=null;
            return root;
        }else if (node.left!=null){
            TreeNode node1 = findPredecessor(node);
            node.val= node1.val;
            node1 = null;
        }else {
            TreeNode node2 = findSuccessor(node);
            node.val = node2.val;
            node2 = null;
        }
        return root;
    }
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) root.right = deleteNode(root.right, key);
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null) root = null;
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);

            }else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;

        }

    }

    public TreeNode deleteNode3(TreeNode root,int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode3(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode3(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = findSuccessor1(root);
                root.right = deleteNode3(root.right, root.val);
            } else {
                root.val = findPredecessor1(root);
                root.left = deleteNode3(root.left, root.val);
            }
        }
        return root;
    }
    private int findPredecessor1(TreeNode node){
        node=node.left;
        while (node.right!=null){
            node = node.right;
        }
        return node.val;
    }
    private int findSuccessor1(TreeNode node){
        node=node.right;
        while (node.left!=null){
            node = node.left;
        }
        return node.val;
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
