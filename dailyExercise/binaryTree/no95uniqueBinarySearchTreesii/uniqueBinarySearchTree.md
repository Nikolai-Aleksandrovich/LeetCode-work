## Algorithm

#### [95. 不同的二叉搜索树 II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii/)

给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。

 

示例 1：

输入：n = 3
输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
示例 2：

输入：n = 1
输出：[[1]]


提示：

1 <= n <= 8

### Solution1回溯(分治)

```java
class Solution {
    public List<TreeNode> generateTrees(int n) {
        //当n为0时，直接返回空链表
        if (n==0){
            return new LinkedList<TreeNode>();
        }
        //不然就进行回溯
        return backTrace(1,n);

    }
    private List<TreeNode> backTrace(Integer start,Integer end){
        //先建立回溯返回值
        List<TreeNode> allTrees = new LinkedList<>();
        //越界
        if (start>end){
            allTrees.add(null);
            return allTrees;
        }
        //
        for (int i = start; i <end; i++) {
            List<TreeNode> leftTrees = backTrace(start,i-1);
            List<TreeNode> rightTrees = backTrace(i,end);
            for (TreeNode left:leftTrees
                 ) {
                for (TreeNode right: rightTrees
                     ) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);

                }

            }
        }
        return allTrees;
        }

    }
```

### Discuss

#### 思路：

* 方法一：回溯

  * 首先判断是否n为0,则返回null

  * 其次建立一个backTrace函数,接受数组起点和终点,只要start<end,就要对所有的i进行遍历并对i左边和i右边进行遍历,找出所有可能的子树,并将它们和i组合起来,得到所有的集合

  * 当start>end时,退出回溯

    

## Review

## Tip



## Share