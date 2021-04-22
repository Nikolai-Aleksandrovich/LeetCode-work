package binaryTree.no1028recoverATreeFromPreorderTraversal;

import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yuyuan Huang
 * @create 2021-04-22 21:11
 */
public class Solution {
    public TreeNode recoverFromPreorder(String S) {
        int length = S.length();
        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;
        while(pos<length){
            int level = 0;
            while (S.charAt(pos)=='-'){
                ++level;
                ++pos;
            }
            //得到高度和索引
            int value = 0;
            while(pos<S.length() && Character.isDigit(S.charAt(pos))){
                value = value*10+(S.charAt(pos)-'0');
                pos++;
            }//得到了数值
            TreeNode node = new TreeNode(value);
            if(level == path.size()){
                if (!path.isEmpty()){
                    path.peek().left=node;
                }
            }else {
                while (level!=path.size()){
                    path.poll();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while(path.size()>1){
            path.pop();
        }
        return path.pop();

    }
    private TreeNode restore(String S){
        Deque<TreeNode> stack = new LinkedList<>();
        if (S==null||S.length()==0){
            return null;
        }

        int length = S.length();
        int pointer = 0;
        stack.push(new TreeNode(S.charAt(0)));
        while (pointer<length){
            int level = 0;
            while (S.charAt(pointer)=='-'){
                pointer++;
                level++;
            }
            pointer++;
            int value = 0;
            while (Character.isDigit(S.charAt(pointer))&&pointer<length){
                value = value*10+(S.charAt(pointer)-'0');
            }
            TreeNode node= new TreeNode();
            if (level == stack.size()){
                stack.peek().left = node;
            }else {
                while(stack.size()!=level){
                    stack.pop();
                }
                stack.peek().right=node;
            }
            stack.push(node);

        }
        while (stack.size()!=1){
            stack.pop();
        }
        return stack.pop();

    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}