## Algorithm

#### [572. 另一个树的子树](https://leetcode-cn.com/problems/subtree-of-another-tree/)

给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

### Solution1层序遍历从上向下寻找相同节点，找到之后递归对比其余节点，当一旦有true通过则返回true（树中可以有重复节点）

```java
class Solution {
    boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root==null&&subRoot==null){
            return true;
        }else if (root==null||subRoot==null){
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
            // System.out.println(node.val);
                // System.out.println(node.val);
                // System.out.println(subRoot.val);
                if (node.val==subRoot.val){
                    ans = compare(node,subRoot);
                    if(ans==true){
                        return ans;
                    }
                
                }
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }

            }
        }
        return ans;

    }
    private boolean compare(TreeNode node1,TreeNode node2){
        
        if (node1==null&&node2==null){
            return true;
        }else if (node1==null||node2==null){
            return false;
        }else if (node1.val!=node2.val){
            return false;
        }
        // System.out.println(node1.val);
        // System.out.println(node2.val);
        return compare(node1.left, node2.left) && compare(node1.right, node2.right);

    }

}
```

### Discuss

#### 思路：

* 方法二：递归，从叶子节点上升到根节点，把本节点的值和本节点的贡献值储存起来，上个节点调用

  


## Review

## Tip



## Share