## Algorithm

#### [19. 删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

### Description

给你一个链表，删除链表的倒数第 `n` 个结点，并且返回链表的头结点。

**进阶：**你能尝试使用一趟扫描实现吗？

```
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
```

### Solution1

```java
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list;
    private Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<Integer>();
        dfs(nestedList);
        cur = list.iterator();

    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }
    private void dfs(List<NestedInteger> nestedList){
        for(NestedInteger element:nestedList){
            if(element.isInteger()){
                list.add(element.getInteger());
            }else{
                dfs(element.getList());
            }
        }
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
```

### solution2：没懂：

我们可以用一个栈来代替方法一中的递归过程。

具体来说，用一个栈来维护深度优先搜索时，从根节点到当前节点路径上的所有节点。由于非叶节点对应的是一个列表，我们在栈中存储的是指向列表当前遍历的元素的指针（下标）。每次向下搜索时，取出列表的当前指针指向的元素并将其入栈，同时将该指针向后移动一位。如此反复直到找到一个整数。循环时若栈顶指针指向了列表末尾，则将其从栈顶弹出。

```

```



### Discuss

#### 思路：

* dfs把所有叶子节点添加到一份列表中，list.iterator.next.hasNext

## Review

## Tip

* 可以看成树的深度优先搜索的顺序就是迭代器便利的顺序

## Share