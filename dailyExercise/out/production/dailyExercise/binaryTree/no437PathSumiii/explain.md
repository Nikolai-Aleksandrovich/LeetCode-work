## Algorithm

#### [437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/)

给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。



## 要点：

## 1：使用前缀和，用Map存放：

前缀和。就是到达当前元素的路径上，之前所有元素的和。

1.父节点大于两个要找的值

2.父节点小于两个值

3.父节点大于一个，小于一个，或者等于一个

设置while循环，让根节点在其中不断寻找

## 2:不是二叉搜索树怎么办？

建立一个Map，存放某个节点和父节点，记录第一个要找的节点的父节点序列，再从第二个序列中找第一个重复的

### solution1二叉搜索树

```java

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
```



### Discuss

#### 思路：








## Review

## Tip



## Share