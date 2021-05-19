## Algorithm

#### [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

### solution1 迭代

```java
class Solution {
   public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0||preorder.length!= inorder.length){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
             if (node.val!=inorder[inorderIndex]){
                 TreeNode temp = new TreeNode(preorder[i]);
                 node.left = temp;
                 stack.push(temp);
             }else {
                 while(!stack.isEmpty()&&stack.peek().val==inorder[inorderIndex]){
                     node = stack.pop();
                     inorderIndex++;
                 }
                 TreeNode right = new TreeNode(preorder[i]);
                 node.right = right;
                 stack.push(right);
             }
        }
        return root;
    }
}
```

#### solution2:递归

```
public TreeNode buildTree2(int[] preorder,int[] inorder){
        int m = preorder.length;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i );
        }
        return buildTree2(preorder,inorder,0,m-1,0,m-1);

    }
    private TreeNode buildTree2(int[] preorder,int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight){
        if (preorderLeft>preorderRight){
            return null;
        }
        int rootValue = preorder[preorderLeft];
        int inorderRootIndex = indexMap.get(rootValue);
        int leftTreeSize = inorderRootIndex-inorderLeft;
        int rightTreeSize = inorderRight-inorderRootIndex;
        TreeNode node = new TreeNode(rootValue);
        node.left = buildTree2(preorder,inorder,preorderLeft+1,preorderLeft+leftTreeSize,inorderLeft,inorderRootIndex-1);
        node.right = buildTree2(preorder,inorder,preorderRight-rightTreeSize+1,preorderRight,inorderRootIndex+1,inorderRight);
        return node;
    }
```



### Discuss

#### 思路：

* 方法一:迭代

  * 中序遍历的结果是{left，root，right}
  * 前序遍历结果{root，left，right}
  * 若只看left child，那么前序和中序是反着来的
  * 所以，先把前序结果放入栈中，将一个指针指向中序的头，每次放入前，都对比栈顶是否与这个指针相同，即可找出一个right，此时，若索引对应的节点和栈顶相同，从栈中弹出节点，同时索引+1，若不同，则上一个弹出的节点即为当前索引的父节点，加入关系，将当前索引对应的节点入栈，对比，放入时，都将下一个作为上一个的left child，
  
* 方法二：递归

  * 可以根据前序遍历确定root，再根据中序确定left tree size，right tree size，

  * 设置（前序数组，中序数组，前序上值，前序下值，中序上值，中序下值），依赖左子树大小，右子树大小，不停的递归
  
    


## Review

## Tip



## Share