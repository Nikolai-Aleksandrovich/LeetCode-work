package no912sortAnArray;

/**
 * @author Yuyuan Huang
 * @create 2021-05-20 12:59
 */
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
