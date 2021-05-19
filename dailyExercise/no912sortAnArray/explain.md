## Algorithm

#### [912. 排序数组](https://leetcode-cn.com/problems/sort-an-array/)

给你一个整数数组 nums，请你将该数组升序排列。

 

示例 1：

输入：nums = [5,2,3,1]
输出：[1,2,3,5]
示例 2：

输入：nums = [5,1,1,2,0,0]
输出：[0,0,1,1,2,5]


提示：

1 <= nums.length <= 50000
-50000 <= nums[i] <= 50000

### Solution1快速排序1

```java
class Solution{
    public int[] sortArray(int[] nums){
        quickSort(nums,0, nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int left,int right){
        if(left<right){
            int mid = partition(nums,left,right);
            quickSort(nums,left,mid-1);
            quickSort(nums,mid+1,right);
        }
    }
    public int partition(int[] nums,int left,int right){
        int randomIndex = new Random().nextInt(right-left+1)+left;
        int value = nums[randomIndex];
        swap(nums,randomIndex,right);
        int i = left-1;
        for (int j = left; j <= right-1; j++) {
            if (nums[j]<=nums[right]){
                i++;
                swap(nums,j,i);
            }
        }
        swap(nums,right,++i);
        return i;
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
```

#### solution2bfs

```
   *
```



### Discuss

#### 思路：

* 方法一:快速排序

  * 主函数调用快排函数
  * **快排函数**接受数组，数组左边界，数组右边界，首先判断是否越界（左>=右），其次利用分割函数获取分割点和两侧的排序效果，其次，递归调用快排函数
  * **分割函数接受数组，数组左边界，数组右边界**，返回分割点
  * 分割点的选取有两种办法：
    * 在刚开始随机初始化数组，每次选择最left的点作为分割点
    * 利用随机数在数组中随机取一个下标，作为分割点
  * 取完分割点后，有两种方法交换不符合要求的值：
    * 将分割点与最右边的点交换，设置i=left-1,遍历left到right-1，当遇到当前j对应的值小于分割点值，i++，交换i和j的值，完成循环后，交换i++和right的值，返回i的值
    * 随机设置nums后，设置i=left，j=right+1；while true下，while i的值符合标准，++i，当i>=right，跳出;while j的值符合标准，--j，当j>=right，跳出;最后将j和left的值交换，返回j

  > 问：为什么要**随机取一个分割点**，浪费资源在“随机的过程中”?
  >
  > 答：这也是一个缺点：当切分不平衡时，程序很低效，在一种极端情况下，每次都取最左索引的最小的点作为基准点：
  >
  > * 这种情况下的比较次数为：n+n-1+n-2+...+2+1=((n+1)*n)/2=n方，时间为平方级别，空间也是线性的
  > * 但如果正常随机取基准数，时间复杂度为0.65N
  >
  > 为什么不平分数组？
  >
  > 答：确实可以在线性时间内找到数组中位数，但是时间复杂度得不偿失

  >  问：**元素重复**会造成额外交换，但这也是为了避免运行时间变为n方
  >
  > 三向切分

  > 改进：
  >
  > * 对于**小数组**，快速排序比插入排序慢，因为快排递归的调用sort方法，可以将right<=left 改成right<=left+(5~15)

  > 问：**快速排序特点**：
  >
  > * 原地排序
  > * 正常情况下时间复杂度n*logn，情况不好时达到n方
  > * 内循环里，用一个变更的索引，将元素数值和一个固定值进行比较，不涉及到元素移动，

* 方法二：bfs

  * bfs，本质上还是层序遍历，只是过程中记录次数

    


## Review

## Tip



## Share