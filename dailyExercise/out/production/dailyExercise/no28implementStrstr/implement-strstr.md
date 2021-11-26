## Algorithm

#### [28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)

### Description

实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

```
输入: haystack = "hello", needle = "ll"
输出: 2

```

### Solution1

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            if(needle.equals(haystack.substring(i,i+needle.length()))){
                return i;
            }
        }
        return -1;
    }
}
```

### solution2

```
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        int pointer1 = 0;
        int pointer2 = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if(needle.charAt(pointer1)==haystack.charAt(i)){
                pointer1++;
                if(pointer1==needle.length()){
                    return haystack.length()-pointer1;
                }
            }else {
                i=i-pointer1;
                pointer1=0;
            }
        }
        return 0;
    }
}
```



### Discuss

##### 思路1：

* solution1和solution2本质上是一种思路，暴力从前往后遍历所有窗口，匹配找到合适的



## Review

## Tip

## Share