## Algorithm

#### [[ 翻转二叉树以匹配先序遍历](https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal/)](https://leetcode-cn.com/problems/construct-string-from-binary-tree/)

一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。

另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。

通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。例，翻转节点 1 的效果如下：

![img](https://assets.leetcode.com/uploads/2021/02/15/fliptree.jpg)


请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。 

如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。

。

#### 思路：

* 方法：递归搜索，每次当root不为空，则先判断root的值是否等于对应的前序遍历值

  * 不等于，则证明不符合条件，再怎么换也不会出现匹配，在list中加入-1，并返回；
  * 等于，则检查左节点否是为空，值是否相等，索引是否越界
    * 是的话，进行递归
    * 否的话，应该交换，加入节点，反着递归
  
  

### Solution1

```java
class Solution {
    int[] voyage;
    int index;
    List<Integer> list;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        list = new ArrayList<>();
        this.voyage = voyage;
        dfs(root);
        if (list.contains(-1)){
            list.clear();
            list.add(-1);
        }
        return list;
    }
    public void dfs(TreeNode node){
        if (node!=null){
            if (node.val!=voyage[index++]){
                list.clear();
                list.add(-1);
            }
            if (node.left!=null&&index< voyage.length&&node.left.val!=voyage[index]){
                list.add(node.val);
                dfs(node.right);
                dfs(node.left);
            }else {
                dfs(node.left);
                dfs(node.right);
            }
            
        }
    }
}
```

### Discuss

#### 思路：

* 方法二：递归，从叶子节点上升到根节点，把本节点的值和本节点的贡献值储存起来，上个节点调用

  


## Review

## Tip



## Share