## Algorithm

#### [26. 删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

### Description

给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

说明:

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。



```
输入：nums = [1,1,2]
输出：2, nums = [1,2]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
```

### Solution

```java
public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int first = 1;
        int second = 0;
        for (;first< nums.length;first++){
            if (nums[first]!=nums[second]){
                second++;
                nums[second]=nums[first];
            }
        }
        return second+1;

    }
```

### Discuss

#### 思路：

* 指针一指向index为1的数，指针二指向index为0的数，当两指针的数字不同，指针二++，指针二的数字替换，相同：指针一前移

## Review

## Tip

## Share