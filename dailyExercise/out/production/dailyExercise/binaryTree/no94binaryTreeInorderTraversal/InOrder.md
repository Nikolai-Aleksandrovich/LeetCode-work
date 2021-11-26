## Algorithm

#### [145. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

给定一个二叉树，返回它的 *中序* 遍历。

### Solution1递归

```java
 private void dfs(TreeNode root){
        if(root!=null){
            
            postorderTraversal(root.left);
            list.add(root.val);
            postorderTraversal(root.right);
       
        }
   	}
```

### solution2迭代

```
private void bfsMid(TreeNode node){
        Deque<TreeNode> deque = new LinkedList<>();

        while(!deque.isEmpty() || node!=null){
            while (node!=null){
                deque.add(node);
                node=node.left;
            }
            TreeNode temp =deque.pop();
            list.add(temp.val);
            node = temp.right;
        }
    }
```



### Discuss

#### 思路：

* 方法一：递归，递归是最简单的，判断当前节点是否为空，对其左子节点右子节点进行递归。中前后序遍历的区别在于何时处理结果（加入list）
* 方法二：迭代
  * 首先判断是否root为空
  * 其次建立一个Stack，首先将以根节点为起点的所有左节点加入该栈
  * 弹出stack顶端一个节点，将他的右节点作为root，并加她本身加入答案数组
    * 若为空，弹出下一个节点
    * 不为空，将右节点作为跟节点，然后将右节点加入stack，并且将该节点的所有左节点加入，重复



## Review

## Tip



## Share