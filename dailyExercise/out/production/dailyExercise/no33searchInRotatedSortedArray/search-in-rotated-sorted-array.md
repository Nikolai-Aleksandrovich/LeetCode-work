## Algorithm

#### [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

### Description

整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。



```
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
```

### Solution1

```java
class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if(length==0){
            return -1;
        }
        if(length==1){
            return nums[0]==target? 0:-1;
        }
        int low = 0;
        int high = length-1;
        while(low<=high){
            int mid = (high-low)/2+low;
            
            if(nums[mid]==target){
                return mid;
            }
            if(low==high){
                return -1;
            }
            if(nums[low]<nums[mid]){
                if(nums[low]<=target&&nums[mid-1]>=target){
                    high=mid-1;
                }else {
                    low = mid+1;
                }
            }else {
                if(nums[mid+1]<=target&&nums[high]>=target){
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }
        }
        return -1;
        


    }
}
```

### solution2：

```
依次遍历，有就返回index
```



### Discuss

#### 思路：

* 方法一：二分查找，分开后，判断mid与target是否相同？再判断左右谁是有序的，再判断有序的是否存在target

## Review

## Tip

## Share