## Algorithm

#### [437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/)

给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。



## 要点：

算法：

* 如果 key > root.val，说明要删除的节点在右子树，root.right = deleteNode(root.right, key)。
* 如果 key < root.val，说明要删除的节点在左子树，root.left = deleteNode(root.left, key)。
* 如果 key == root.val，则该节点就是我们要删除的节点，则：
  * 如果该节点是叶子节点，则直接删除它：root = null。
  * 如果该节点不是叶子节点且有右节点，则用它的后继节点的值替代 root.val = successor.val，然后删除后继节点。
  * 如果该节点不是叶子节点且只有左节点，则用它的前驱节点的值替代 root.val = predecessor.val，然后删除前驱节点。
* 返回 root。



### solution1

```java

class Solution {
  /*
  One step right and then always left
  */
  public int successor(TreeNode root) {
    root = root.right;
    while (root.left != null) root = root.left;
    return root.val;
  }

  /*
  One step left and then always right
  */
  public int predecessor(TreeNode root) {
    root = root.left;
    while (root.right != null) root = root.right;
    return root.val;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;

    // delete from the right subtree
    if (key > root.val) root.right = deleteNode(root.right, key);
    // delete from the left subtree
    else if (key < root.val) root.left = deleteNode(root.left, key);
    // delete the current node
    else {
      // the node is a leaf
      if (root.left == null && root.right == null) root = null;
      // the node is not a leaf and has a right child
      else if (root.right != null) {
        root.val = successor(root);
        root.right = deleteNode(root.right, root.val);
      }
      // the node is not a leaf, has no right child, and has a left child    
      else {
        root.val = predecessor(root);
        root.left = deleteNode(root.left, root.val);
      }
    }
    return root;
  }
}

```



### Discuss

#### 思路：








## Review

## Tip



## Share