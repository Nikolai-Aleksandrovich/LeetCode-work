## Algorithm

#### [[894. 所有可能的满二叉树](https://leetcode-cn.com/problems/all-possible-full-binary-trees/)](https://leetcode-cn.com/problems/construct-string-from-binary-tree/)

满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。

返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。

答案中每个树的每个结点都必须有 node.val=0。

你可以按任何顺序返回树的最终列表。

#### 思路：

* 方法：

* 每个满二叉树 T*T* 含有 3 个或更多结点，在其根结点处有 2 个子结点。这些子结点 `left` 和 `right` 本身就是满二叉树。

* 因此，对于N≥3，我们可以设定如下的递归策略：对于所有的 x，所有的树的左子结点来自 FBT(x) 而右子结点来自 FBT(N−1−x)。

* 应该缓存函数 FBT 之前的结果，这样我们就不必在递归中重新计算它们。

  
  
* 

### Solution1

```java
class Solution {
    HashMap<Integer,List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new LinkedList<>();
        if (!memo.containsKey(n)){
            if (n==1){
                list.add(new TreeNode(0));
            }else if (n%2==1){
                for (int i = 0; i < n; i++) {
                    int j = n-i-1;
                    for (TreeNode left:allPossibleFBT(i)){
                        for (TreeNode right:allPossibleFBT(j)){
                            TreeNode node = new TreeNode(0);
                            node.left=left;
                            node.right = right;
                            list.add(node);
                        }
                    }
                    
                }
            }
            memo.put(n,list);
        }
        return memo.get(n);
    }
}
```

### Discuss

#### 思路：






## Review

## Tip



## Share