package no26removeDuplicatesFromSortedArray;

/**
 * @author Yuyuan Huang
 * @create 2021-03-23 16:51
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int second = 0;
        for (int first = 1;first< nums.length;first++){
            if (nums[first]!=nums[second]){
                second++;
                nums[second]=nums[first];
            }
        }
        return second+1;

    }
}
