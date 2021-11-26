## Algorithm

#### [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

### Description

给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

```
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
```

### Solution

```java
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        System.arraycopy(nums1,0,nums3,0,m);
        int p2 = 0;
        int p3 = 0;
        int p = 0;
        while (p2<n && p3<m){
            nums1[p++] = (nums3[p3]<nums2[p2])? nums3[p3++]:nums2[p2++];

        }
        if(p3<m){
            System.arraycopy(nums3,p3,nums1,p2+p3,m+n-p2-p3);
        }
        if(p2<n){
            System.arraycopy(nums2,p2,nums1,p2+p3,m+n-p2-p3);
        }

    }
}
```

### Discuss

#### 思路：

* 设置对两个数组两个指针，从0开始，将较小的值放在新数组中。
* 当某一个数组遍历完时，使用System.arraycopy()将另一数组剩余的元素移动到目标数组
* 注意System.arraycopy()参数的使用



## Review

## Tip
* ```
  * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
  *
  * src:源数组;
  *
  * srcPos:源数组要复制的起始位置;
  *
  * dest:目的数组;
  *
  * destPos:目的数组放置的起始位置;
  *
  * length:复制的长度.
  ```

## Share