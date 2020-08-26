import javax.swing.tree.TreeNode;
import java.util.Stack;

public class Solution {
    public TreeNode mirrorTree(TreeNode root){
        //请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//        TreeNode temp = root.right;
//        root.right = root.left;
//        root.left = temp;
//
//        if(root.left != null || root.right != null){
//            mirrorTree(root.left);
//            mirrorTree(root.right);
//        }
//        return root;
        //使用stack的方法先进后出；
        if(root.left==null||root.right==null)return null;
        Stack<TreeNode> stack = new Stack<>(){
            {
                add(root);
            }
        };
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.left!=null){
                stack.add(curr.left);
            }
            if(curr.right!=null){
                stack.add(curr.right);
            }

            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;



        }
        return root;


    }
}
