## Algorithm

#### [701. 二叉搜索树中的插入操作](https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/)

给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。



#### 思路：

* 方法：从根节点判断，应该左移还是右移，并将根节点变为该移动的节点，再进行比较，假如节点为空，则进行插入
* 时间n空间1

### Solution1

```java
public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while(pos!=null){
            if (val<pos.val){
                if (pos.left==null){
                    pos.left=new TreeNode(val);
                    break;
                }else {
                    pos = pos.left;
                }
            }else {
                if (pos.right==null){
                    pos.right = new TreeNode(val);
                    break;
                }else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }
```

### Discuss

#### 思路：

* 

  


## Review

## Tip



## Share