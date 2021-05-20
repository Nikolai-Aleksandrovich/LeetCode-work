package no912sortAnArray;

/**
 * @author Yuyuan Huang
 * @create 2021-05-20 13:56
 */
public class ShellSort {
    public int[] shellSort(int[] nums){
        int n = nums.length;
        int h = 1;
        while (h<n/3){
            h=3*h+1;
        }

        while (h>=1){
            for (int i = h; i < n; i++) {
                for (int j = i; j >=h&&(nums[j]<nums[j-h]) ; j-=h) {
                    swap(nums,j,j-h);
                }
            }
            h=h/3;
        }



        return nums;
    }
    public int[] shellSort1(int[] nums){
        int length = nums.length;
        int h = 1;
        while(h<=length){
            h=h*3+1;
        }
        while(h>0){
            for (int i = h; i < length; i++) {
                for (int j = i; j >=h&&nums[j]>nums[j-1] ; j-=h) {
                    swap(nums,j,j-1);
                }
            }
            h=h/3;
        }
        return nums;
    }
    public int[] shellSort2(int[] num){
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
