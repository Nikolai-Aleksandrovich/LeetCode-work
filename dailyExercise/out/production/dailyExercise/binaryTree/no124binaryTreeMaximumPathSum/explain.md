## Algorithm

#### [124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)

路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

路径和 是路径中各节点值的总和。

给你一个二叉树的根节点 root ，返回其 最大路径和 。

## 要点：先计算左子树，在计算右子树，如果任何的值比0小，则取0，父节点的值由左右子树中最大的值+父节点得到，当子树为null，其值为0；

### solution1递归

```java
class Solution {
    int maxSum = Integer.MIN_VALUE;
   public int maxPathSum(TreeNode root){
        maxGain(root); 
        return maxSum;
    }
    public int maxGain(TreeNode node){
        if (node==null){
            return 0;
        }
        int leftSum = Math.max(maxGain(node.left),0);
        int rightSum = Math.max(maxGain(node.right),0);
        maxSum = Math.max(maxSum,(leftSum+rightSum+node.val));
        return  Math.max(leftSum,rightSum)+node.val;
    }
}
```

### Discuss

#### 思路：








## Review

## Tip



## Share