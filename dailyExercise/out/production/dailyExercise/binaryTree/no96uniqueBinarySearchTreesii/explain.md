## Algorithm

#### [96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/)

给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。

 

示例 1：


输入：n = 3
输出：5
示例 2：

输入：n = 1
输出：1


提示：

1 <= n <= 19



### Solution1DP

```java
package binaryTree.no96uniqueBinarySearchTreesii;

/**
 * @author Yuyuan Huang
 * @create 2021-05-14 17:42
 */
class Solution {
//    public int numTrees(int n) {
//        return backTrace(1,n);
//
//    }
    public int numTrees(int n) {
        int[] pool = new int[n+1];
        pool[0] = 1;
        pool[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <=i ; j++) {
                pool[i] = pool[j-1]*pool[i-j];
            }
        }
        return pool[n];
    }
  
}
```

solution2:回溯

```
 private int backTrace(int start,int end){
        int totalNum = 0;
        if (start>end){
            return 0;
        }
        for (int i = start; i < end+1; i++) {
            int leftNum = backTrace(start,i-1);
            System.out.println(leftNum);

            int rightNum = backTrace(i+1,end);
            System.out.println(rightNum);
            if (leftNum==0&&rightNum==0){
                totalNum+=1;
            }else if (rightNum==0){
                totalNum+=leftNum;
            }else if (leftNum==0){
                totalNum+=rightNum;
            }else {
                totalNum += leftNum*rightNum;
            }
        }
        return totalNum;
    }
```



### Discuss

#### 思路：

* 方法一:DP

  * 因为原问题可以分解成规模较小的两个子问题，且子问题的解可以复用。
  * G0=G1=1;G2=遍历N并加和(左右树相乘),求到Gn即可
  
* 方法二：回溯

  * 首先判断是否n为1,则返回1

  * 其次建立一个backTrace函数,接受数组起点和终点,只要start<end,就要对所有的i进行遍历并对i左边和i右边进行遍历,找到子树数量,对左子右子数量相乘得到可能的数量

  * 当start>end时,退出回溯

    

## Review

## Tip



## Share