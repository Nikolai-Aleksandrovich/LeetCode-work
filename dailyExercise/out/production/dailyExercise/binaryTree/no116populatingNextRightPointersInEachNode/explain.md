## Algorithm

#### [[116. 填充每个节点的下一个右侧节点指针](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)](https://leetcode-cn.com/problems/path-sum-ii/)

给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

 

进阶：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

### solution1 层序遍历，设置指向

```java
public Node connect(Node root) {
        if (root==null){
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.pollFirst();
                if (size-i==1){
                    temp.next=null;
                }else {
                    temp.next = queue.peekFirst();
                }
                if (temp.left!=null){
                    queue.offerLast(temp.left);
                }
                if (temp.right!=null){
                    queue.offerLast(temp.right);
                }
            }

        }
        return root;
}
```

#### solution2:递归，用上一层的指向辅助修改下一层的指向

```java

class Solution {
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        root.next = null;
        helper(root);
        return root;

    }
    private void helper(Node node){
        if (node == null||node.left==null){
            return;
        }
        node.left.next = node.right;
        if (node.next!=null){
            node.right.next = node.next.left;
        }else {
            node.right.next = null;
        }
        helper(node.left);
        helper(node.right);
        
    }
}
```



### Discuss

#### 思路：

* 方法一:层序遍历

  * 每次遍历这一层，指向，当最后一个时，就指向空 N N
  
    
  
* 方法二：递归，使用上一层辅助修饰下一层

  

  


## Review

## Tip



## Share