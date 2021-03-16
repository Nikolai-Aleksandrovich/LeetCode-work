## Algorithm

2.[两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

### Description

给定一个字符串，请你找出其中不含有重复字符的 **最长子串** 的长度。

```
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。xxxxxxxxxx 输入：l1 = [2,4,3], l2 = [5,6,4]输出：[7,0,8]解释：342 + 465 = 807.输入: s = "abcabcbb"输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

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
                hashSet.remove(s.charAt(left));
            }
            while(left+1<length&&!hashSet.contains(s.charAt(i))){
                hashSet.add(s.charAt(i));
                left++;
            }
            ans = Math.max(ans,left-i+1);
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

## Share