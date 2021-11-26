## Algorithm

#### [[654. 最大二叉树](https://leetcode-cn.com/problems/maximum-binary-tree/)](https://leetcode-cn.com/problems/construct-string-from-binary-tree/)

给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：

二叉树的根是数组 nums 中的最大元素。
左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
返回有给定数组 nums 构建的 最大二叉树 。

#### 思路：

* 方法：递归深度优先搜索，首先设置一个方法，将根节点选出来，并设置根节点左右节点，重复调用本方法，其次，设置一个找到根节点索引的方法，递归进行

  

### Solution1

```java
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0, nums.length);
    }
    public TreeNode construct(int[] nums,int l,int r){
        if (l==r){
            return null;
        }
        int maxIndex = findMax(nums,l,r);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = construct(nums,l,maxIndex);
        node.right = construct(nums,maxIndex+1,r);
        return node;
    }
    private int findMax(int[] nums,int l,int r){
        int tempMaxIndex = l;
        for (int i = l; i < r; i++) {
            if (nums[i]>nums[tempMaxIndex]){
                tempMaxIndex=i;
            }
        }
        return tempMaxIndex;
    }
}
```

### Discuss

#### 思路：

* 方法二：递归，从叶子节点上升到根节点，把本节点的值和本节点的贡献值储存起来，上个节点调用

  


## Review

## Tip



## Share