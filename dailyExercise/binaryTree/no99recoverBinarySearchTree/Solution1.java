package no99recoverBinarySearchTree;


/**
 * @author Yuyuan Huang
 * @create 2021-05-28 15:11
 */
public class Solution1 {
    TreeNode pre = new TreeNode();
    int count;
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    public void recoverTree(TreeNode root) {
        search(root);
        System.out.println(node1.val);
        System.out.println(node2.val);
        System.out.println(node3.val);
        swap();
    }
    public void search(TreeNode node){
        if (node == null||count==2){
            return;
        }
        search(node.left);
        if (node.val< pre.val&&count==0){
            node1 = pre;
            node2 = node;
            count++;
        }else if (node.val< pre.val&&count==1){
            node3 = node;
            count++;
        }
        search(node.right);
    }
    private void swap(){
        if (count==1){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }else if (count==2){
            int temp = node1.val;
            node1.val = node3.val;
            node3.val = temp;
        }
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