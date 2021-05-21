## Algorithm

#### [113. 路径总和 II](https://leetcode-cn.com/problems/path-sum-ii/)

给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。



### solution1 广度优先搜索

```java
class Solution {
    List<List<Integer>> ans1 = new LinkedList<>();
    Map<TreeNode,TreeNode> map = new HashMap<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null){
            return ans1;
        }
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> valueQueue = new LinkedList<>();
        nodeQueue.push(root);
        map.put(root,null);
        valueQueue.push(root.val);
        while(!nodeQueue.isEmpty()){
            TreeNode temp = nodeQueue.pollFirst();
            int value = valueQueue.pollFirst();
            if (temp.left==null&&temp.right==null){
                if (value == sum){
                    TreeNode findFather = temp;
                    Deque<Integer> list = new LinkedList<>();
                    while (map.get(findFather)!=null){
                        list.addFirst(findFather.val);
                        findFather = map.get(findFather);
                    }
                    list.addFirst(root.val);
                    ans1.add(new LinkedList<>(list));
                }
            }
            if (temp.left!=null){
                map.put(temp.left,temp);
                nodeQueue.push(temp.left);
                valueQueue.push(value+ temp.left.val);
            }
            if (temp.right!=null){
                map.put(temp.right,temp);
                nodeQueue.push(temp.right);
                valueQueue.push(value+ temp.right.val);
            }
        }
        return ans1;
    }
}
```

#### solution2:深度优先递归

```java
public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        dfs1(root,targetSum);
        return ans;
    }
    private void dfs1(TreeNode root,int targetSum){
        if (root==null){
            return;
        }
        list.addLast(root.val);
        targetSum=targetSum-root.val;
        if (root.left==null&&root.right==null&&targetSum==0){
            ans.add(new LinkedList<>(list));
        }
        dfs1(root.left,targetSum);
        dfs1(root.right,targetSum);
        list.pollLast();
    }
```



### Discuss

#### 思路：

* 方法一:广度优先

  * 两个队列，一个存储值，一个存储节点，一个ans的list负责返回，一个map负责存储一个结点的父节点
  * 每次队首取出一个节点，取出一个值，若无左右节点，判断值是否相等，若相等：while循环找出所有的父节点，将父节点放入Deque中，再通过add.(new LinkedList(list))放进答案数组，若有，将左右节点加进去，分别加上其value，并入队
  
    
  
* 方法二：深度优先

  * 其实只要每次将target的值减去根节点的值，并且使用一个deque维护一个列表，当到了根节点，就判断是否相等，若相等，将数组利用add.(new LinkedList(list))放进答案数组，若不相等，就递归左右树，最后要移除栈顶的元素

    
  
    


## Review

## Tip



## Share