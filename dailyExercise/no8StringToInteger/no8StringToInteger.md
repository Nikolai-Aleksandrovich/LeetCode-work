## Algorithm

#### [8. 字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)

### Description

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

```
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
```

### Solution

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int low = 0;
        int high = nums.length-1;
        while (low<=high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid]==target){
                if(mid==low){
                    start=mid;
                }else {
                    if(nums[mid-1]==target){
                        start=headCal(nums,low,mid-1,target);
                    }else {
                        start=mid;
                    }
                }
                if(mid == high){
                    end=mid;
                    System.out.println("s"+start+"e"+end);
                    return new int[]{start,end};
                }else {
                    if(nums[mid+1]==target){
                        end=tailCal(nums,mid+1,high,target);
                        System.out.println("s"+start+"e"+end);
                        return new int[]{start,end};
                    }else {
                        end=mid;
                        System.out.println("s"+start+"e"+end);
                        return new int[]{start,end};
                    }
                }

            }else if(nums[mid]>target){
                high=mid-1;
            }else {
                low=mid+1;
            }


        }
        System.out.println("s"+start+"e"+end);
        return new int[]{start,end};

    }
    private int headCal(int[] nums,int low,int high,int target){
        while(low<=high){
            if(high==low){
                return low;
            }
            int mid = (high-low)/2+low;
            if(nums[mid]!=target){
                low=mid+1;
            }else {
                if(mid==low){
                    return mid;
                }else if(nums[mid-1]==target){
                    high=mid-1;
                }else {
                    return mid;
                }

            }
        }
        return -1;
    }
    private int tailCal(int[] nums,int low,int high,int target){
        while (low<=high){
            if(high==low){
                return low;
            }
            int mid = (high-low)/2+low;
            if(nums[mid]!=target){
                high=mid-1;
            }else {
                if(mid==high){
                    return mid;
                }else
                if(nums[mid+1]==target){
                    low=mid+1;
                }else {
                    return mid;
                }

            }
        }
        return -1;
    }

}
```

### Discuss

##### 思路1：

二分查找，根据mid有三种情况，第一，mid切分了要找的字符串，那么就需要去两边寻找，第二，mid左边是要找的字符串，mid右边是要找的字符串



## Review

## Tip

## Share