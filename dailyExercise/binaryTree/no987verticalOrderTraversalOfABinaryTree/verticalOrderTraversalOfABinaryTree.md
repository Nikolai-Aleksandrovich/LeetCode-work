## Algorithm

#### [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

给你一个二叉树，请你返回其按 **层序遍历** 得到的节点值。 （即逐层地，从左到右访问所有节点）。



### Solution1先层序遍历，后排序序号

```java
package binaryTree.no987verticalOrderTraversalOfABinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-04-22 14:49
 */
public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root==null){
            return lists;
        }
        Deque<NewNode> deque = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        deque.offer(new NewNode(root,new int[]{0,0}));
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                NewNode temp = deque.poll();
                TreeNode node = temp.node;
                if (node.left!=null){
                    int[] now = calIndex(temp.cor[0],temp.cor[1],true);
                    deque.offer(new NewNode(true,temp.cor,now,node.left));
                    list.add(temp.cor);
                }
                if(node.left!=null){
                    int[] now = calIndex(temp.cor[0],temp.cor[1],false);
                    deque.offer(new NewNode(false,temp.cor,now,node.left));
                    list.add(temp.cor);

                }
            }

        }
        return lists;

    }
    private int[] calIndex(int prex,int prey,boolean isLeft){
        if (isLeft){
            return new int[]{prex+1,prey-1};
        }else {
            return new int[]{prex+1,prey+1};
        }

    }

}
class NewNode{
    boolean isLeft;
    TreeNode node;
    int[] fatherCor;
    int[] cor;
    NewNode(){};
    NewNode(int[] s){
        this.cor = s;
    }
    NewNode(boolean isLeft,int[] fatherCor,int[] cor,TreeNode node){
        this.isLeft = isLeft;
        this.fatherCor = fatherCor;
        this.cor = cor;
        this.node = node;
    }
    NewNode(TreeNode node,int[] cor){
        this.node = node;
        this.cor = cor;
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
```



### Discuss

#### 思路：

* 方法一：队列：

  * 首先层序遍历：

  * 其次按照序号排列

    

  



## Review

## Tip



## Share