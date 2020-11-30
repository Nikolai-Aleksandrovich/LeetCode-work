package com.itranswarp.sample;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

public class InorderTraversal {
    //中序遍历各种方法汇总
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode predecessor = null;
        while(root!=null){
            // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
            if(root.left!=null){
                predecessor=root.left;
                while(predecessor.right!=null&&predecessor.right!=root){
                    predecessor=predecessor.right;
                }
                //如果Predecessor右边节点为空，那就把它指向根
                if(predecessor.right==null){
                    predecessor.right = root;
                    root = root.left;
                }
                //如果不为空，那就说明这个左树其实已经指向root了，已经遍历完 xx 的左子树
                else {
                    list.add(root.val);
                    predecessor.right =null;
                    root=root.right;
                }

            }
            //不然左为空，就直接把当前加入答案，然后查看右树
            else {
                list.add(root.val);
                root=root.right;
                }
            }
        return list;
        }

    /**
     * this is a Stack-like iterate way to inorderTraversal a BST
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root!=null||!deque.isEmpty()){//这两者都不成立的时候，直接返回，因为此时root跟为空
            //build a stack contains of all left element,for each element,next will deal with
            //their right element
            while (root!=null){
                deque.add(root);
                root=root.left;
            }
            root = deque.poll();//pull the leftest element
            list.add(root.val);//add it's value into ans list
            root=root.right;//search for it's right node

        }
        return list;
    }


    /**
     * by use recursive way,three step:1.find the leftest node,add it  2.add root  3.deal with right one
     * @param root
     * @return
     */
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }
    private void inorder(TreeNode root,List<Integer> list){
        //this is the end statement
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }*/
}
