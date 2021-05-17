## Algorithm

#### [100. 相同的树](https://leetcode-cn.com/problems/same-tree/)

给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

 

示例 1：


输入：p = [1,2,3], q = [1,2,3]
输出：true
示例 2：


输入：p = [1,2], q = [1,null,2]
输出：false
示例 3：

输入：p = [1,2,1], q = [1,1,2]
输出：false


提示：

两棵树上的节点数目都在范围 [0, 100] 内
-104 <= Node.val <= 104



### Solution1深度优先

```java
public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null){
            return true;
        }else if (p==null||q==null){
            return false;
        }else if (p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }


    }
```

#### solution2:广度优先

```

class Solution {
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue1.push(p);
        queue2.push(q);
        while(!queue1.isEmpty()&&!queue2.isEmpty()){ ;
            TreeNode temp1 = queue1.pollFirst();
            TreeNode temp2 = queue2.pollFirst();
            if (temp1.val==temp2.val){
                if (temp1.left!=null&& temp2.left!=null){
                    queue1.push(temp1.left);
                    queue2.push(temp2.left);
                }else if (temp1.left==null&&temp2.left!=null){
                    return false;
                }else if (temp2.left==null&&temp1.left!=null){
                    return false;
                }
                if (temp2.right!=null&&temp1.right!=null){
                    queue1.push(temp1.right);
                    queue2.push(temp2.right);
                }else if (temp1.right==null&&temp2.right!=null){
                    return false;
                }else if (temp2.right==null&&temp1.right!=null){
                    return false;
                }
            }else{
                return false;
            }
        }
        return queue1.size() == 0 && queue2.size() == 0;
    }
}
```



### Discuss

#### 思路：

* 方法一:深度优先

  * 判断本节点是否符合规则，再重复调用自身，判断下一节点
  
* 方法二：广度优先

  * 维护两个队列，不断地出队，判断，加入子节点入队，再重复

    


## Review

## Tip



## Share