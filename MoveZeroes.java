package com.itranswarp.sample;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums==null){
            return;
        }
        int zeroPointer = 0;
        int otherNumCount = 0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=0){
                int tmp = nums[i];
                nums[i] = nums[zeroPointer];
                nums[zeroPointer++] = tmp;
            }
        }
    }
    /**
     * public void moveZeroes(int[] nums) {
     *         int zeroPointer = 0;
     *         int otherNumCount = 0;
     *         while (zeroPointer!=nums.length-1){
     *             if(nums[zeroPointer]==0){
     *                 zeroPointer++;
     *             }
     *             if(nums[otherNumCount]!=0){
     *                 otherNumCount++;
     *             }
     *             if(nums[zeroPointer]!=0&&nums[otherNumCount]==0){
     *                 int temp=nums[zeroPointer];
     *                 nums[zeroPointer]=nums[otherNumCount];
     *                 nums[otherNumCount]=temp;
     *             }
     *         }
     *
     *     }
     * @param nums
     */

}
