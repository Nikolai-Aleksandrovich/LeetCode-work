## Algorithm

#### [590. N 叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)

给定一个n叉树，返回它的 *后序* 遍历。

### Solution1递归

```java
private void dfs(Node root){
        if (root!=null){
            for (Node node:root.children
                 ) {
                dfs(node);
                list.add(node.val);
            }
        }

    }
```

### solution2迭代

```
private List<Integer> bfs(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null){
            return output;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node item :
                    node.children) {
                stack.push(item);
            }
        }
        return output;
    }
```



### Discuss

#### 思路：

* 方法一：递归，递归是最简单的，判断当前节点为空吗？不空的话遍历所有子节点，直到所有子节点为空，就加入队列

* 方法二：迭代

  * 首先判断是否root为空

  * 其次建立一个LinkedList Stack，一个LinkedList Output，首先把根节点放入stack，当stack不为空的情况下，取出一个，放入output，并把他的所以子节点放入stack，直到stack为空

  * 此时，因为是链表，所以刚好顶端就是后序遍历的第一个值

  * 为什么链表可以当作列表？

    * 因为链表实现了list接口和Deque接口

    * ArrayList实现了Abstract List接口

    * Stack继承了Vector，Vector实现了Enumerate和Abstract List接口

      



## Review

## Tip



## Share