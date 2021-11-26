## Algorithm

#### [[297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)

序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。



## 要点：

## 1：二叉树的序列化可以将“结构”和“value”转为String：

1.当节点为空时，转为None，

2.当节点不为空，前序遍历，并逐个加入String

3.反序列化要将String转为Array，每次读取第0个，并删除

### solution1

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
public String preSerialize(TreeNode node,String str){
            if (node==null){
                str+="None,";
                return str;
            }
            str= str+node.val+",";
            str = preSerialize(node.left,str);
            str = preSerialize(node.right,str);
            return str;
        }
        public String serialize(TreeNode root){
            return preSerialize(root,"");
        }
        public TreeNode reSerialize(List<String> list){

            if (list.get(0).equals("None")){
                list.remove(0);
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
            list.remove(0);
            node.left = reSerialize(list);
            node.right = reSerialize(list);
            return node;

        }
        public TreeNode deserialize(String s){
            // System.out.println(s);
            String[] sList = s.split(",");
            List<String> list =new LinkedList<>( Arrays.asList(sList));
            return reSerialize(list);
        }
        }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
```



### Discuss

#### 思路：








## Review

## Tip



## Share