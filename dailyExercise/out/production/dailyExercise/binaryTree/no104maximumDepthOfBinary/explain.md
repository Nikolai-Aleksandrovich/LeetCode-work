## Algorithm

#### [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。
返回它的最大深度 3 。

### Solution1dfs

```java

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }

    }
}
```

#### solution2bfs

```
   *
```



### Discuss

#### 思路：

* 方法一:dfs

  * 每次调用maxdepth(left),depth(right)，返回最大的值
  
* 方法二：bfs

  * bfs，本质上还是层序遍历，只是过程中记录次数

    


## Review

## Tip



## Share