## Algorithm

#### [41. 缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive/)

给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 

进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？

```
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
```

### Solution1

```java
public int firstMissingPositive(int[] nums) {
        if(nums.length==0){
            return 1;
        }
        if (nums.length==1){
            return nums[0]==1 ? 2:1 ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0 && nums[i]<=nums.length){
                exchange(nums,nums[i],nums[i]-1,i);
            }
        }
        if (nums[0]!=1){
            return 1;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1]-nums[i]!=1){
                return i+2;
            }else if(i+2== nums.length){
                return i+3;
            }
        }

        return 0;

    }
    private void exchange(int[] nums,int curValue,int destIndex,int origin){
        if(origin==destIndex){
            nums[origin]=curValue;
            return;
        }
        if(curValue==nums[destIndex]){
            return;
        }
        int temp = nums[destIndex];
        nums[destIndex]=curValue;
        if (temp>0 && temp< nums.length){
            exchange(nums,temp,temp-1,origin);
        }else {
            nums[origin]=temp;
        }
    }
```

### solution2

```
public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                priorityQueue.add(nums[i]);
            }
        }
        while (!priorityQueue.isEmpty()){
            if (priorityQueue.peek()!=1){
                return 1;
            }
            if (priorityQueue.size()==1){
                return priorityQueue.peek()+1;
            }
            int smaller = priorityQueue.poll();
            int small = priorityQueue.peek();
            if(small!=smaller){
                if(small-smaller!=1){
                    return smaller+1;
                }
            }



        }
        return 0;

    }
```

### solution3

```
public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int element:nums) {
            if (element>0){
                hashSet.add(element);
            }
        }
        int length = hashSet.size();
        for (int i = 1; i < length+2; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }
        return 0;
    }
```



### Discuss

#### 思路：

* 方法一：On，空间1，遍历所以元素，对大于0而且小于数组长度的数字，排序到当前数字-1对应的下标处，最后检查即可
* On，On，遍历所有元素，放到优先队列，依次弹出并判断
* On，On，遍历所有元素，排序，检查。

## Review

## Tip



## Share