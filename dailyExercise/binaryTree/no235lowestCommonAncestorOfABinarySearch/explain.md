## Algorithm

#### [[235. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)

给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]



## 要点：

## 1：因为是二叉搜索树，所以只有三种情况：

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