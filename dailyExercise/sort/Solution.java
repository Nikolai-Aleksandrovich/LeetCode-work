package sort;

/**
 * @author Yuyuan Huang
 * @create 2021-04-16 16:23
 */
public class Solution {
    int[] tmp;

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        sortAndMerge(nums,0, nums.length-1);
        return nums;

    }
    private void sortAndMerge(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int length = nums.length;
        int mid = (right+left)>>1;
        sortAndMerge(nums,left,mid);
        sortAndMerge(nums,mid+1,right);
        int i = left;
        int j = mid+1;
        int cnt = 0;
        while(i<=mid&&j<=right){
            if (nums[i]<nums[j]){
                tmp[cnt] = nums[i];
                cnt++;
                i++;
            }else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i<=mid){
            tmp[cnt++]=nums[i++];
        }
        while (j<=right){
            tmp[cnt++]=nums[j++];
        }
        for (int k = 0; k < right-left+1; k++) {
            nums[k+left] = tmp[k];
        }
    }
}
