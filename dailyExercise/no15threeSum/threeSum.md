## Algorithm

#### [15. 三数之和](https://leetcode-cn.com/problems/3sum/)

给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

```
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
```

### Solution

```java
public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for(int first = 0; first<length;first++){
            if(first!=0 && nums[first]==nums[first-1]){
                continue;
            }
            int third = length-1;
            int target = -nums[first];
            for (int second = first+1;second<length;second++){
                if(second!=first+1 && nums[second]==nums[second-1]){
                    continue;
                }
                while (second<third && nums[second]+nums[third]>target){
                    third--;
                }
                if(second==third){
                    break;
                }
                if(nums[second]+nums[third]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[second] );
                    list.add(nums[third] );
                    list.add(nums[first] );
                    ans.add(list);
                }
            }
        }
        return ans;



    }
```

### Discuss

#### 思路：

* 设置三个指针，第一个指针从头开始，第二个指针从指针1+1开始，第三个指针从尾开始

* 在第一个指针固定，第二个指针固定，当条件满足，移动第三个指针得到答案

* 也要判断，避免出现重复：检查该指针和前面的指针指向是否相同？

  

## Review

## Tip



## Share