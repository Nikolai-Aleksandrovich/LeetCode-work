## Algorithm

#### [[110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

 

示例 1：

输入：root = [3,9,20,null,null,15,7]
输出：true
示例 2：


输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
示例 3：

输入：root = []
输出：true


提示：

树中的节点数在范围 [0, 5000] 内
-104 <= Node.val <= 104



### solution1 自顶向下递归

```java
public boolean isBalanced1(TreeNode root) {
        if (root==null){
            return true;
        }
        return Math.abs(heightCal(root.left) - heightCal(root.right))<=1 &&isBalanced1(root.left)&&isBalanced1(root.right);

    }
    private int heightCal(TreeNode node){
        if (node!=null&&node.left==null&&node.right==null){
            return 1;
        }else if (node==null){
            return 0;
        }else{
            return Math.max(heightCal(node.left),heightCal(node.right))+1;
        }

    }
```

#### solution2:自下向上递归

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return heightCal(root)==-1? false:true;
    }
    private int heightCal(TreeNode root){
        if(root ==null){
            return 0;
        }
        int left = heightCal(root.left);
        int right = heightCal(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }else{
            return Math.max(left,right)+1;
        }
    }

}
```



### Discuss

#### 思路：

* 方法一:自顶向下递归

  * 一个辅助方法，用来求左右子树的高度
  * 调用这个方法，并且不断对子树使用主函数
  * 
  
* 方法二：自下向上递归

  * 一个辅助方法，从root开始，对每个左右节点求左右子树的高度，当高度不符合要求，则设置返回值为-1

  * 主函数判断是否为-1即可
  
    
  
    


## Review

## Tip



## Share