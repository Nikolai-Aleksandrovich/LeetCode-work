package com.itranswarp.sample;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

        /**
         * 哈希表查
         * public int[] twoSum(int[] nums, int target) {
         * HashSet<Integer> hashMap = new HashSet<>();
         *         for (int element:nums){
         *             if(hashMap.contains(target-element)){
         *                 return new int[]{element,target-element};
         *             }else {
         *                 hashMap.add(element);
         *             }
         *         }
         *         return new int[0];
         *     }
         */

    /**
     * 先用二分查找，再双指针
     * public int[] twoSum(int[] nums, int target) {
     *         int lo=0,hi= nums.length-1,mid=-1;
     *         while(lo<hi){
     *             mid=(hi+lo)/2;
     *             if (nums[mid]>target){
     *                 hi=mid-1;
     *             }else{
     *                 lo=mid+1;
     *             }
     *         }
     *
     *         int i=0,j=hi;
     *         while(i<j){
     *             int minus = target-nums[i];
     *             if(minus<nums[j]){
     *                 j--;
     *             }else if(minus>nums[j]){
     *                 i++;
     *             }else {
     *                 return new int[]{nums[i],nums[j]};
     *             }
     *         }
     *         return new int[0];
     *     }
     * @param nums
     * @param target
     * @return
     */

    /**
     * 直接用双指针碰撞
     * public int[] twoSum(int[] nums, int target) {
     *         int firstIndex = 0;
     *         int lastIndex = nums.length-1;
     *         int[] ans= new int[2];
     *         while (nums[firstIndex]+nums[lastIndex]!=target){
     *             if(nums[firstIndex]+nums[lastIndex]>target){
     *                 lastIndex=lastIndex-1;
     *             }
     *             if(nums[firstIndex]+nums[lastIndex]<target){
     *                 firstIndex=firstIndex+1;
     *             }
     *         }
     *         ans[0]=nums[firstIndex];
     *         ans[1]=nums[lastIndex];
     *         return ans;
     *
     *     }
     * @param nums
     * @param target
     * @return
     */

    /**
     * 超时
     * public int[] twoSum(int[] nums, int target) {
     * //        int cutNumber= whenToCut(nums,target);
     *         int[] ans= new int[2];
     *         for (int i=0;i<nums.length;i++){
     *             for (int j=0;j< nums.length;j++){
     *                 if(i==j){
     *                 }else {
     *                     if(nums[i]+nums[j]==target){
     *                          ans[0]=nums[j];
     *                          ans[1]=nums[i];
     *                     }
     *                 }
     *             }
     *         }
     *         return ans;
     *     }
     * //    private int whenToCut(int[] nums, int target){
     * //        for (int i=0;i<nums.length;i++){
     * //            if(nums[i]>target){
     * //                return i;
     * //            }
     * //        }
     * //        return nums.length;
     * //    }
     * @param nums
     * @param target
     * @return
     */

}


