## Algorithm

#### [606. 根据二叉树创建字符串](https://leetcode-cn.com/problems/construct-string-from-binary-tree/)

你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。

空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

#### 思路：

* 方法：递归深度优先搜索，进行前序遍历，根左右，每一次加入节点都装饰上（），最后删除最左边和最右边的（）即可

  

### Solution1

```java
class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb = dfs(root);
        System.out.println(sb);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }
    private StringBuilder dfs(TreeNode node){
        StringBuilder stringBuilder = new StringBuilder();
        if (node==null){
            return stringBuilder;
        }
        if (node.left==null&&node.right==null){
            stringBuilder.append('(');
            stringBuilder.append(node.val);
//            stringBuilder.append(')');
        }else if (node.left==null){
            stringBuilder.append('(');
            stringBuilder.append(node.val);
            stringBuilder.append("()");
        }else {
            stringBuilder.append("(").append(node.val);
        }
        // System.out.println(stringBuilder);
        stringBuilder.append(dfs(node.left));
        stringBuilder.append(dfs(node.right));
        stringBuilder.append(")");
        return stringBuilder;
    }
}
```

### Discuss

#### 思路：

* 方法二：递归，从叶子节点上升到根节点，把本节点的值和本节点的贡献值储存起来，上个节点调用

  


## Review

## Tip



## Share