package no912sortAnArray;

/**
 * @author Yuyuan Huang
 * @create 2021-05-21 17:04
 */
public class DuiSort {
    //进行下沉排序
    public int[] sortArray(int[] nums){
        int N = nums.length;
        for (int i = N/2; i >=1 ; i--) {
            sink(nums,i);
        }
        while (N>1){
            swap(nums,1,N--);
            sink(nums,1);
        }
        return nums;

    }
    private void sink(int[] nums,int index){
        while(index*2<=nums.length){
            int j = 2*index;
            //判断是否要移动指针到右边节点上（因为右边节点大于左节点）
            if (j<nums.length&&nums[j]<nums[j+1]){
                j++;
            }
            if (nums[index]<nums[j]){
                swap(nums,index,j);
                index = j;
            }else {
                break;
            }
        }
    }
    private void swim(int[] nums,int index){
        while (index>=1){
            int j = index/2;
             if (nums[j]<nums[index]){
                 swap(nums,j,index);
                 index = j;
             }else {
                 break;
             }

        }
    }
    public int[] sortArray1(int[] nums){
        int N = nums.length;
        for (int i = N/2; i <=1 ; i--) {
            sink(nums,N);
        }
        while (N>=1){
            swap(nums,1,--N);
            sink(nums,1);
        }
        return nums;
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

