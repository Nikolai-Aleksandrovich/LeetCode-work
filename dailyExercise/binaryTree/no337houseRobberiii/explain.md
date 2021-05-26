## Algorithm

#### [337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)

在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。





## 要点：

## 1：动态规划，从下往上，则需要逆序遍历整棵树，记录选该点的值和不选该点的值：

GMap存放不选择该点时，该点可取得最大值，FMap存放：

* G（node） = 左子树G和F的最大值+右子树G和F的最大值
* F（node） = 左子树G的值+右子树G的值+当前值

### solution1二叉搜索树

```java
class Solution {
    Map<TreeNode,Integer> GMap = new HashMap<>();
    Map<TreeNode,Integer> FMap = new HashMap<>();
    int res = 0;
    public int rob(TreeNode root) {
        dfs(root);
        return res;        
    }
    private void dfs(TreeNode node){
        if (node==null){
            return;
        }
        dfs(node.left);
        dfs(node.right);
        int nodeG = Math.max(FMap.getOrDefault(node.left,0),GMap.getOrDefault(node.left,0))+Math.max(FMap.getOrDefault(node.right,0),GMap.getOrDefault(node.right,0));
        // System.out.println("G"+nodeG);
        GMap.put(node,Math.max(FMap.getOrDefault(node.left,0),GMap.getOrDefault(node.left,0))+Math.max(FMap.getOrDefault(node.right,0),GMap.getOrDefault(node.right,0)));
        int nodeF = GMap.getOrDefault(node.left,0)+GMap.getOrDefault(node.right,0)+node.val;
                // System.out.println("F"+nodeF);
        FMap.put(node,nodeF);
        res = Math.max(nodeF,nodeG);
    }
}
```



### Discuss

#### 思路：








## Review

## Tip



## Share