package no912sortAnArray;

import java.util.Random;

/**
 * @author Yuyuan Huang
 * @create 2021-05-19 11:09
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums,0, nums.length-1);
        return nums;

    }
    //如果左指针不大于右指针，
    public void  randomizedQuicksort(int[] nums,int left,int right){
        if (left<right){
            int pos = randomizedPartition(nums,left,right);
            randomizedQuicksort(nums,left,pos-1);
            randomizedQuicksort(nums,pos+1,right);
        }


    }
    //找到随机一个数，交换这个数和最右边一个数，然后对整个数组进行左右筛选
    public int randomizedPartition(int[] nums,int left,int right){
        int i = new Random().nextInt(right-left+1)+1;
        swap(nums,right,i);
        return partition(nums, left, right);

    }
    //对已经交换的数组左右进行筛选
    public int partition(int[] nums,int left,int right){
        int pivot = nums[right];
        int i = left-1;
        for (int j = left; j <= right-1; j++) {
            if (nums[j]<=pivot){
                i=i+1;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,right);
        return i+1;



    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j] = temp;
    }
}

class MyQuickSort2{
    public int[] sortArray(int[] nums){
        randomQuickSort(nums,0, nums.length-1);
        return nums;
    }
    public void randomQuickSort(int[] nums,int left,int right){
        if (left<right){
            int mid = randomPartition(nums,left,right);
            randomQuickSort(nums,left,mid-1);
            randomQuickSort(nums,mid+1,right);
        }

    }
    public int randomPartition(int[] nums,int left,int right){
        int randomIndex = new Random().nextInt(right-left+1)+l;
        swap(nums,right,randomIndex);
        return partition(nums,left,right);
    }
    public int partition(int[] nums,int left,int right){
        int i = left-1;
        int value = nums[right];
        for (int j = left; j <= right-1; j++) {
            if (nums[j]<=value){
                i++;
                swap(nums,i,j);
            }

        }
        swap(nums,i+1,right);
        return i+1;

    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
class MyQuickSort{
    public int[] sort(int[] nums){
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int left,int right){
        if (right<=left){
            return;
        }
        int mid = partition(nums,left,right);
        quickSort(nums,left,mid-1);
        quickSort(nums,mid+1,right);

    }
    public static int partition(int[] nums,int left,int right){
        int v = new Random().nextInt(right-left+1)+1;
        int value = nums[v];
        int i = right+1;
        int j = left;
        while(true){
            while (nums[i]<value){
                i--;
                if (i==v){
                    break;
                }
            }
            while (nums[j]>value){
                j++;
                if (j==v){
                    break;
                }
            }
            if (j>=i){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,j,v);
        return j;
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
class MyQuickSort3{
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
