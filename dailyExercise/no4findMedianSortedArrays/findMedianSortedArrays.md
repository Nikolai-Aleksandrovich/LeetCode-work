## Algorithm

2.[两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

### Description

给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。



示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
### Solution

```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int length = s.length();
        int left = -1;
        int ans = 0;
        for (int i = 0; i < s.length() ; i++) {
            if(i!=0){
                hashSet.remove(s.charAt(i));
            }
            while(left+1<length&&!hashSet.contains(s.charAt(left+1))){
                hashSet.add(s.charAt(left+1));
                left++;
            }
            ans = Math.max(ans,left-i);
        }
        return ans;
    }
}
```

### Discuss

#### 思路：

* 首先使用Set找到最长字串为何物
* 首指针和尾指针分别指向0和最长字串长度
* 先把尾指针向后移，添加新的元素进入set，当存在，表示无法拓展，记录max值，将首指针后移
* 一直走直到首指针走完所有值



## Review

## Tip
* 每次remove的是i-1,为什么？因为每次需要remove第一个字符，而remove操作是从i=1开始算
* left指针从0开始，从1开始都可以

## Share