## Algorithm

#### [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)

给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### Solution1中序遍历

```java

public class Solution {

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.pop();
            if (temp.left!=null){
                if (temp.left.val>=temp.val){
                    return false;
                }else {
                    queue.push(temp.left);
                }
            }
            if (temp.right!=null){
                if (temp.right.val<=temp.val){
                    return false;
                }else {
                    queue.push(temp.right);
                }
            }
            
        }
        return true;
    }
    
    
}
```

#### solution2:递归

```
    private boolean helper(TreeNode root,int lower,int upper){
        if (root==null){
            return true;
        }
        if (root.val<=lower&&root.val>=upper){
            return false;
        }
        return helper(root.left,lower,root.val)&&helper(root.right,root.val,upper);
    }
```



### Discuss

#### 思路：

* 方法一:DP

  * 中序遍历的结果就是有序的（二叉树搜索）
  
* 方法二：递归

  * 设置（根节点，上值，下值），不停的递归

    


## Review

## Tip



## Share