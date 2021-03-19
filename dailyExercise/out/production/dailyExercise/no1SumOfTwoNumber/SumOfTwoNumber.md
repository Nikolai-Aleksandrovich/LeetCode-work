## Algorithm

[1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

### Description

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案。

```
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
```

### Solution

```java
class Solution {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{i, hashMap.get(target-nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }
}

```

### Discuss

#### 两种思路：

##### 思路1：

暴力，两次遍历数组并求和

时间：O平方

空间：O1

##### 思路2：

创建一个空hashmap，依次遍历数组，并验证是否存在target-num[i]的值存在于hashmap中，不存在则存放当前{num[i],i}，存在则返回

时间：On

空间：On

## Review

## Tip

## Share