## Algorithm

#### [145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

给定一个二叉树，返回它的 *后序* 遍历。

### Solution1递归

```java
 private void dfs(TreeNode root){
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
   	}
```

### solution2迭代

```
private void bfs(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right==null || root.right==prev){
                //左右都已经加入了

                list.add(root.val);
                prev = root;
                root = null;
            }else {
                //再装回去，然后继续往stack放

                stack.push(root);
                root=root.right;
            }
        }

    }
```



### Discuss

#### 思路：

* 方法一：递归，递归是最简单的，判断当前节点是否为空，对其左子节点右子节点进行递归。中前后序遍历的区别在于何时处理结果（加入list）
* 方法二：迭代
  * 首先判断是否root为空
  * 其次建立一个Stack，首先将以根节点为起点的所有左节点加入该栈
  * 弹出stack顶端一个节点，查找他的右节点是否（存在且遍历过（prev））
    * 是的话，直接将根节点加入答案中，找上一个根节点
    * 不是的话，将根节点重新加入stack，然后将右节点加入stack，并且将该节点的所有左节点加入，重复



## Review

## Tip



## Share