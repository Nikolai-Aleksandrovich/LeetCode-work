package offer.rebuildBinaryTree.BSTAndTwoWayLinkedList36;


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-07-26 20:38
 */
public class Solution {

    public Node treeToDoublyList(Node root) {
        if (root==null){
            return null;
        }
        dfs(root);
        return concat();

    }
    List<Node> list = new ArrayList<>();
    public void dfs(Node root){
        if (root!=null){
            dfs(root.left);
            list.add(root);
            dfs(root.right);
        }
    }
    public Node concat(){
        Node head = null;
        for (int i = 0; i < list.size(); i++) {
            Node temp = list.get(i);

            if (i==0){
                head = temp;
                temp.left = list.get(list.size()-1);
                temp.right = list.get(i+1);
            }else if (i==list.size()-1){
                temp.right = list.get(0);
                temp.left = list.get(i-1);
            }else {
                temp.right = list.get(i+1);
                temp.left = list.get(i-1);
            }
        }
        return head;
    }

}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};