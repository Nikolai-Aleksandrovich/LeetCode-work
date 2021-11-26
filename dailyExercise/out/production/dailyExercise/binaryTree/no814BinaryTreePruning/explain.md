## Algorithm

#### [[814. 二叉树剪枝](https://leetcode-cn.com/problems/binary-tree-pruning/)](https://leetcode-cn.com/problems/construct-string-from-binary-tree/)

给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。

返回移除了所有不包含 1 的子树的原二叉树。

( 节点 X 的子树为 X 本身，以及所有 X 的后代。)

#### 思路：

* 方法：递归搜索，将null与左右为true，本节点为0的设为true，要判断最终是否整棵树存在

  

### Solution1

```java
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return judge(root)? null:root;
    }
    public boolean judge(TreeNode node){
        if (node==null){
            return true;
        }
        boolean left = judge(node.left);
        boolean right = judge(node.right);
        
        
        if (left&&right){
            node.left=null;
            node.right = null;
            return node.val == 0;
        }
        else if (left){
            node.left=null;
            return false;
        }
        else if (right){
            node.right = null;
            return false;
        }
        return false;

    }
}
```

### Discuss

#### 思路：

* 方法二：递归，从叶子节点上升到根节点，把本节点的值和本节点的贡献值储存起来，上个节点调用

  


## Review

## Tip



## Share