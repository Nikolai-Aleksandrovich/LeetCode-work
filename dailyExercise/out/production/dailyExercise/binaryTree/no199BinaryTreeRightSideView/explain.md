## Algorithm

#### [199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)

给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。



## 要点：

## 1：先进行层序遍历，每次取最后一个节点

## 2：用两个队列一个map，边记录深度，边取最后的元素

### solution1层序遍历

```java
class Solution {
   public List<Integer> rightSideView(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        deque.push(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {

                TreeNode node = deque.pollFirst();
                if (node.left!=null){
                    deque.offerLast(node.left);

                }
                if (node.right!=null){
                    deque.offerLast(node.right);

                }
                if (i==size-1){
                    list.add(node.val);
                }
            }

        }
        return list;
    }
    
}
```

## solution2

```java
public List<Integer> rightSideView1(TreeNode root){
        Map<Integer,Integer> map = new HashMap<>();
        int maxDepth = -1;
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> valueQueue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        nodeQueue.push(root);
        valueQueue.push(0);
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.pop();
            int curDepth = valueQueue.pop();
            if (node.left!=null){
                nodeQueue.push(node.left);
                valueQueue.push(curDepth+1);
            }
            if (node.right!=null){
                nodeQueue.push(node.right);
                valueQueue.push(curDepth+1);
            }
            if (!map.containsKey(curDepth)){
                map.put(curDepth,node.val);
            }
        }
        int size = map.size();
        for (int i = 0; i < size; i++) {
            list.add(map.get(i));
        }

        return list;

    }
```



### Discuss

#### 思路：








## Review

## Tip



## Share