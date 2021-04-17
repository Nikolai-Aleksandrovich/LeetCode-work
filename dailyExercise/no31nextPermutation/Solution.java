package no31nextPermutation;

/**
 * @author Yuyuan Huang
 * @create 2021-04-17 20:16
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        //找到第一对相邻的降序列
        while (i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        //此时 要么全部都是升序的 比如[3,2,1]
        //要么是指针指到相邻降序 [1,2,3] i = 1指向2
        if(i>=0){
            int j = nums.length-1;
            //
            while (j>=0 && nums[i]>=nums[j]){
                j--;
            }
            //此时的j指向大于i的数,比如是3
            swap(nums,i,j);

        }
        reverse(nums,i+1);

    }
    private void swap(int[] nums,int i,int j){
        int temp = j;
        j = i;
        i = temp;
    }
    private void reverse(int[] nums,int start){
        int left = start;
        int right = nums.length-1;
        while(left<right){
            swap(nums,start,right);
            left++;
            right--;
        }
    }
}
