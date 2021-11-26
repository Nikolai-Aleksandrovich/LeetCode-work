## Algorithm

#### [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

给你一个二叉树，请你返回其按 **层序遍历** 得到的节点值。 （即逐层地，从左到右访问所有节点）。



### Solution1双端队列

```java
 public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root==null){
            return lists;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = deque.pollFirst();
                list.add(temp.val);
                if (temp.left!=null){
                    deque.offer(temp.left);
                }
                if (temp.right!=null){
                    deque.offer(temp.right);
                }
            }
            lists.add(list);
        }
        return lists;

    }
```



### Discuss

#### 思路：

* 方法一：队列：

  * 首先给队列中加入root，只要队列不为空，循环：
    * 取出队列当前的size，每次弹出一个首部元素，把这个元素放入答案数组，当存在左右子节点，则放入队列
    * 当队列为空，那么就是遍历完所有节点

  



## Review

## Tip



## Share