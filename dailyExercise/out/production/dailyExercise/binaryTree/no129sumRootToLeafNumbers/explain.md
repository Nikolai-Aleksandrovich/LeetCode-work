## Algorithm

#### [29. 求根节点到叶节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)

给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：

例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
计算从根节点到叶节点生成的 所有数字之和 。

叶节点 是指没有子节点的节点。



## 要点：

## 1：递归，当为空返回，将当前节点的值加到累计值中，当为叶子节点，就累加到结果上

## 2:用两个数组，一个存放节点结构，一个存放值；

### solution1递归

```java
nt result = 0;
    int tempAns = 0;
    private void dfs(TreeNode node){
        if (node == null){
            return;
        }
        if (node.left==null&&node.right==null){
            tempAns = tempAns*10+ node.val;
            result = result+tempAns;
            tempAns = (tempAns- node.val)/10;
            return;
        }
        tempAns = tempAns*10+ node.val;
        dfs(node.left);
        dfs(node.right);
        tempAns = (tempAns- node.val)/10;
    }
```

### solution2广度优先

```java
 Deque<TreeNode> nodeQueue = new LinkedList<>();
    Deque<Integer> valueQueue = new LinkedList<>();
 public int sumNumbers(TreeNode root) {
        int ans = 0;
        if (root==null){
            return ans;
        }
        nodeQueue.push(root);
        valueQueue.push(root.val);
        while (!nodeQueue.isEmpty()){
            TreeNode temp = nodeQueue.pollFirst();
            Integer value = valueQueue.pollFirst();
            if (temp.left!=null){
                nodeQueue.offerLast(temp.left);
                Integer tempValue = value*10+ temp.left.val;
                valueQueue.offerLast(tempValue);
            }
            if (temp.right!=null){
                nodeQueue.offerLast(temp.right);
                Integer tempValue = value*10+ temp.right.val;
                valueQueue.offerLast(tempValue);
            }
            if (temp.right==null&&temp.left==null){
                ans = ans+value;
            }


        }
        return ans;

    }
```



### Discuss

#### 思路：








## Review

## Tip



## Share