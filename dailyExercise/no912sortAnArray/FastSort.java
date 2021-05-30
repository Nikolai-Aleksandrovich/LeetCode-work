package no912sortAnArray;

import java.util.Random;

/**
 * @author Yuyuan Huang
 * @create 2021-05-26 18:05
 */
public class FastSort {
    public int[] sortArray(int[] nums){
        if (nums==null){
            return null;
        }
        sort(nums,0, nums.length-1);
        return nums;
    }
    public void sort(int[] nums,int left,int right){
        if (left>=right){
            return;
        }
        int mid = partition(nums,left,right);
        sort(nums,left,mid-1);
        sort(nums,mid+1,right);
    }
    public int partition(int[] nums,int left,int right){
        int mid = new Random().nextInt(right-left+1)+left;
        int index1 = left-1;
        int index2 = left;
        swap(nums,mid,right);
        for (int i = left; i < right; i++) {
            if (nums[i]<=nums[right]){
                while (true){
                    if(nums[++index1]<=nums[right]){

                    }else {
                        break;
                    }
                }
                swap(nums,index1,i);
            }
        }
        swap(nums,++index1,right);
        return mid;
    }
    private void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
