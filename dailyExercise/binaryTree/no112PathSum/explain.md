## Algorithm

#### [[112. 路径总和](https://leetcode-cn.com/problems/path-sum/)](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。

叶子节点 是指没有子节点的节点。



示例 1：


输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
输出：true
示例 2：


输入：root = [1,2,3], targetSum = 5
输出：false
示例 3：

输入：root = [1,2], targetSum = 0
输出：false


提示：

树中节点的数目在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000





### solution1 广度优先搜索

```java
 public boolean hasPathSum1(TreeNode root,int targetSum){
        if (root == null){
            return false;
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> valueQueue = new LinkedList<>();
        nodeQueue.push(root);
        valueQueue.push(root.val);
        while(!nodeQueue.isEmpty()){
            TreeNode temp = nodeQueue.pop();
            int value = valueQueue.pop();
            if (temp.left==null&&temp.right==null){
                if (value==targetSum){
                    return true;
                }
            }
            if (temp.right!=null){
                nodeQueue.push(temp.right);
                valueQueue.push(temp.right.val+value);
            }
            if (temp.left!=null){
                nodeQueue.push(temp.left);
                valueQueue.push(temp.left.val+value);
            }
        }
        return false;

    }
```

#### solution2:深度优先递归

```java
class Solution {
   public boolean hasPathSum2(TreeNode root,int targetSum){
        if (root==null){
            return false;
        }
        if (root.left==null&&root.right==null){
            if (root.val==targetSum){
                return true;
            }
        }
        return hasPathSum2(root.left, targetSum-root.val)||hasPathSum2(root.right, targetSum-root.val);

    }

}
```



### Discuss

#### 思路：

* 方法一:广度优先

  * 两个队列，一个存储值，一个存储节点，
  * 每次队首取出一个节点，取出一个值，若无左右节点，判断值是否相等，若有，将左右节点加进去，分别加上其value，并入队
  
    
  
* 方法二：深度优先

  * 其实只要每次将target的值减去根节点的值，当到了根节点，就判断是否相等

    
  
    
  


## Review

## Tip



## Share