## Algorithm

#### [543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/)

给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 

### Solution1

```java
class Solution {
    HashMap<TreeNode,Integer> lengthMap = new HashMap<>();
    HashMap<TreeNode,Integer> contributeLMap = new HashMap<>();
    List<Integer> maxLength = new ArrayList<>();
    List<Integer> maxContributeLength = new ArrayList<>();
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        int maxVal = 0;
        for(TreeNode node: lengthMap.keySet()){
            // System.out.println("s");
            // System.out.println(node.val);
            // System.out.println(lengthMap.get(node));
            // System.out.println("e");
            maxVal = Math.max(maxVal,lengthMap.get(node));
        }
        // for(TreeNode node: contributeLMap.keySet()){
        //     System.out.println("s1");
        //     System.out.println(node.val);
        //     System.out.println(contributeLMap.get(node));
        //     System.out.println("e1");

        // }
        if(maxVal==0){
            return 0;
        } else{
return maxVal-1;
        }
        
    }
    private void dfs(TreeNode node){
        if (node==null){
            return;
        }
        dfs(node.left);
       
        dfs(node.right);
        int maxLeft = contributeLMap.getOrDefault(node.left,0);
        int maxRight = contributeLMap.getOrDefault(node.right,0);
        // System.out.println(node.val);
        // System.out.println(maxLeft);
        // System.out.println(maxRight);
        
        if(node.left==null&&node.right==null){
            lengthMap.put(node,0);
            contributeLMap.put(node,1);
        }else {
            lengthMap.put(node,maxLeft+maxRight+1);
            contributeLMap.put(node,Math.max(maxLeft,maxRight)+1);
        }
    }
}
```

### Discuss

#### 思路：

* 方法二：递归，从叶子节点上升到根节点，把本节点的值和本节点的贡献值储存起来，上个节点调用

  


## Review

## Tip



## Share