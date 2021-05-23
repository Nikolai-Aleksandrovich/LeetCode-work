package binaryTree.no173BinarySearchTreeIterator;


import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-05-22 16:22
 */
class BSTIterator {
    int curPointer = -1;
    List<TreeNode> inorder;
    public BSTIterator(TreeNode root) {
        inorder = inorder(root);
        for (TreeNode treeNode : inorder) {
            System.out.println(treeNode);
        }

    }

    public int next() {
        curPointer++;
        return inorder.get(curPointer).val;
    }

    public boolean hasNext() {
        return curPointer < inorder.size()-1;

    }
    private List<TreeNode> inorder(TreeNode node){
        List<TreeNode> list = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        while(!queue.isEmpty()||node!=null){
            while(node!=null){
                queue.push(node);
                node = node.left;
            }
            TreeNode temp = queue.pop();
            if (temp.right!=null){
                list.add(temp);
                node = temp.right;
            }else {
                list.add(temp);
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