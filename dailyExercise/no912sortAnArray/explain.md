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

#### solution2选择排序

> 特点：
>
> * 运行时间和输入无关 n方
> * 数据移动很少->N

```java
   public class SelectSort {
    public int[] selectSort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (nums[j]<nums[min]){
                    min = j;
                }

            }
            swap(nums,min,i);
        }
        return nums;
    }
    private static  void  swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j] = temp;
    }
}

```

### solution3插入排序

>  特点：
>
> * 当数组大范围有序的情况，会很快，因为他就会在n的时间内完成
> * 当数组大范围无序，则交换次数为n方

```java
public class InsertSort {
    public int[] insertSort(int[] nums){
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >0&&(nums[j]<nums[j-1]) ; j--) {
                swap(nums,j,j-1);
            }
        }
        return nums;
    }
    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

### solution4希尔排序

> 特点：
>
> * 当数组大范围无序的情况，会很快，先选择一个收敛到1的递增序列，以他的增加顺序最大值作为跨度，进行排序，不断缩小跨度
> * 时间复杂度n的1.5次方
> * 当数组大范围无序的数组表现很好

```java
class Solution{
    public int[] sortArray(int[] num){
        int length = num.length;
        int h = 1;
        while(h<length){
            h=h*3+1;
        }
        while(h>0){
            for (int i = h; i < length; i++) {
                for (int j = i; j >=h&&num[j]<num[j-1] ; j-=h) {
                    swap(num,j,j-1);
                }
            }
            h=h/3;
        }
        return num;
    }
    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

### solution5自顶向下的归并排序

>要将一个数组排序，可以先递归的将两半的数组排好序，再将它们合并起来
>
>改进：
>
>* **对于小数组：**使用插入排序来处理长度小于15的数组，能使归并总体效率上升15%
>* **对于已经有序的数组**：在merge前判断如果mid+1>=mid，那么跳过merge，因为人家已经有序了，可以把n*logn变为n
>* 
>
>特点：
>
>* 所有的元素需要实现了comparable接口
>
>* 需要额外n的空间，需要n*logn的时间

```java
class Solution{
    private static int[] aux;
    public int[] sortArray(int[] nums){

        int length =  nums.length;
        aux = new int[length];
        sort(nums,0,length-1);
        return nums;
        
    }
    public void sort(int[] nums,int left,int right){
        if (right<=left){
            return;
        }
        int length = nums.length;
        int mid = (right+left)/2;
        sort(nums,left,mid);
        sort(nums,mid+1,right);
        mergeAndSort(nums,left,mid,right);
        
    }
    public void mergeAndSort(int[] nums,int left,int mid,int right){
        int i = left;
        int j = mid+1;
        for (int k = left; k < right+1; k++) {
            aux[k] = nums[k];
        }
        for (int k = left; k < right+1; k++) {
            if (i>mid){
                nums[k] = aux[j++];
            }else if (j>right){
                nums[k] = aux[i++];
            }else if (aux[i]<aux[j]){
                nums[k] = aux[i++];
            }else {
                nums[k] = aux[j++];
            }
        }
        
    }
}
```

### solution6自底向上

```java
class MergeAndSort{
    private static int[] aux;
    public int[] sortArray(int[] nums){
        int n = nums.length;
        aux = new int[n];
        for (int sz = 1; sz < n; sz=sz+sz) {
            for (int left = 0; left < n-sz; left=sz+sz+left) {
                merge4(nums,left,left+sz-1,Math.min(left+sz+sz-1,n-1));
            }
        }
    }
    public void merge4(int[] nums,int left,int mid,int right){
        int i = left;
        int j = mid+1;
        for (int k = left; k < right+1; k++) {
            aux[k] = nums[k];
        }
        for (int k = left; k < right+1; k++) {
            if (i>mid){
                nums[k] = aux[j++];
            }else if (j>right){
                nums[k] = aux[i++];
            }else if (aux[i]<aux[j]){
                nums[k] = aux[i];
            }else {
                nums[k] = aux[j];
            }
        }

    }
}
```

### 堆的知识点：

> 什么是二叉堆：一颗二叉树每个节点都大于等于两个子节点，根节点是堆有序的二叉树中最大的节点
>
> * 完全二叉树只用数组而不用指针就可以表示，只需要层序将节点放入数组姐可以
> * **二叉堆**：一组能用堆有序的完全二叉树排序的元素，在数组中按照层级储存
> * **父节点索引**：在堆中，位置k的父节点索引是k/2
> * **子节点计算：**一个父节点的两个子节点索引分别是2*k与2*k+1
> * 可以不使用指针，只使用索引在数组中模拟指针的移动
> * **大小：**一颗节点数为N的完全二叉树，高度为logN，意味着：当树节点数量到达2的幂次时，树的高度增加1
>
> 

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

#### 方法一:选择排序

* 每次选择剩余数组中最小的数放在剩余数组最左边
* 计算下来比较次数为N+N-1+N-2+...+2+1 = n方，交换次数为N
* **快排函数**接受数组，数组左边界，数组右边界，首先判断是否越界（左>=右），其次利用分割函数获取分割点和两侧的排序效果，其次，递归调用快排函数
* **分割函数接受数组，数组左边界，数组右边界**，返回分割点
* 分割点的选取有两种办法：
  * 在刚开始随机初始化数组，每次选择最left的点作为分割点
  * 利用随机数在数组中随机取一个下标，作为分割点
* 取完分割点后，有两种方法交换不符合要求的值：
  * 将分割点与最右边的点交换，设置i=left-1,遍历left到right-1，当遇到当前j对应的值小于分割点值，i++，交换i和j的值，完成循环后，交换i++和right的值，返回i的值
  * 随机设置nums后，设置i=left，j=right+1；while true下，while i的值符合标准，++i，当i>=right，跳出;while j的值符合标准，--j，当j>=right，跳出;最后将j和left的值交换，返回j



## Share

### 优先队列的实现方式：

* 使用无序数组实现：

  * 插入（1）：插入到数组未使用的索引
  * peek（N）：使用一次选择排序，选择最大的元素并把它返回
  * pop：使用一次选择排序，将最大的元素与边界元素交换，并返回他
  * 如何控制阈值：当元素数量小于总长度0.25，则resize，当元素数量大于总长度0.75，则resize
  
* 使用有序数组实现：
  * 插入（N）：每次将比插入元素大的元素向右移动一格
  * peek（1）：选择最右边最大的元素并把它返回
  * pop：选择最右边最大的元素，删除并返回
  * 如何控制阈值：当元素数量小于总长度0.25，则resize，当元素数量大于总长度0.75，则resize

* 使用链表：
  * 插入：从链表头往里走，遇到和自己相同或者比自己小的元素，将自身指向它，它的父节点指向自己
  * peek和pop：直接返回链表头
  * resize，要记录一下链表长度
  
* 使用堆（完全二叉树）实现

  * **什么是完全二叉树？**这个二叉树层序遍历，I位置对应的满二叉树的i位置相同，那么就可以成为完全二叉树

  * **什么是二叉堆**：将完全二叉树节点层序遍历放到数组中，不要用0号索引

    >将一个大小为N+1的数组表示一个N的堆,要有什么功能?
    >
    >* 交换 swap
    >* 比较 compare
    >* 上浮 swim
    >* 下沉 sink
    >
    > > 当插入时,插入到堆尾部,不断比较自身和根节点的大小,来决定留在原地还是和父节点交换
    > >
    > > 当remove最大元素,此时根节点比左右两个都小,或者比任意一个小,那么这个根就应该和两个子节点中值较大的交换,并不断比较

#### 使用堆实现优先队列:

* 拓展功能的思绪:
  * 多叉堆:用数组表示三叉堆
    * 位置K的节点,他的左中右元素为3*K-1,3*K,3K+1,他的父元素为(K+1)/3
  * 调整数组大小:
    * 添加一个空构造函数
    * 在insert中添加一个将数组长度设置为2倍的方法
    * 在poll中添加一个将数组长度减半的方法
  * 元素保证是不可变的,不然计算好的位置,在查找的时候,就找不到
  * 

```java
public class PriorityQueue<Key extends Comparable<Key>> {
    private Key[] nums; //基于堆的完全二叉树
    private int N = 0;     //0没有使用,N表示长度

    public PriorityQueue(int maxN){
        //为0留下位置
        nums =  (Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void insert(Key value){
        nums[++N] = value;
        swim(N);
    }
    public Key poll(){
        Key ans = nums[1];
        swap(1,N--);
        nums[N+1] = null;
        sink(1);
        return ans;

    }


    private void swap(int i,int j){
        Key temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private boolean less(int a,int b){
        return nums[a].compareTo(nums[b])<0;
    }
    private void swim(int index){
        while(index>1&&less(index/2,index)){
            swap(index,index/2);
            index = index/2;
        }

    }
    private void sink(int index){
        while(2*index<=N){
            int j = 2*index;
            if (j<N&&less(j,j+1)){
                j++;
            }
            if (!less(index,j)){
                break;
            }
            swap(index,j);
            index = j;
        }
    }

}

```

