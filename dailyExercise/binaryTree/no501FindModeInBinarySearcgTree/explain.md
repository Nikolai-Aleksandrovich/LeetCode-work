## Algorithm

#### [[501. 二叉搜索树中的众数](https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/)](https://leetcode-cn.com/problems/path-sum-iii/)

给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

## 要点：

算法：

* 首先dfs搜索这个BST
* 设置一个update函数：
  * 每当值相等，就将count++，如果值不相等，就将当前值设置为base值，将count设置为1
  * 每次检查当前count是否等于maxcount，是的话，在list加入当前值，如果count大于当前值，清空list，在list加入当前值，设置最大值等于当前计数
* 返回 nums



### solution1

```java
public class Solution {
    List<Integer> answer = new ArrayList<>();
    int value,count,maxCount;
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;

    }
    private void dfs(TreeNode node){
        if (node==null){
            return;
        }
        dfs(node.left);
        update(node.val);
        dfs(node.right);
    }
    private void update(int curVal){
        if (curVal==value){
            count++;
        }else {
            count=1;
            value = curVal;
        }
        if (count==maxCount){
            answer.add(value);
        }else if (count>maxCount){
            maxCount = count;
            answer.clear();
            answer.add(value);
        }

    }
}
```



### Discuss

#### 思路：








## Review

## Tip



## Share