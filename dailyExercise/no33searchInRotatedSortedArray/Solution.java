package no33searchInRotatedSortedArray;

import com.sun.source.tree.BreakTree;

/**
 * @author Yuyuan Huang
 * @create 2021-03-23 18:11
 */
public class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if(length==0){
            return -1;
        }
        if(length==1){
            return nums[0]==target? 0:-1;
        }
        int low = 0;
        int high = length-1;
        while(low<=high){
            int mid = (high-low)/2+low;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<nums[mid]){
                if(nums[low]<=target&&nums[mid-1]>=target){
                    high=mid-1;
                }else {
                    low = mid+1;
                }
            }else {
                if(nums[mid+1]<=target&&nums[high]>=target){
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }
        }
        return -1;



    }
//    public int search(int[] nums, int target) {
//        int length = nums.length;
//        if(length==0){
//            return -1;
//        }
//        if(length==1){
//            return nums[0]==target? 0:-1;
//        }
//        int low = 0;
//        int high = length-1;
//        while(low<=high){
//            int mid = (high-low)/2+low;
//            if(nums[mid]==target){
//                return mid;
//            }
//            if(nums[0]<=nums[mid]){
//                if(nums[0]<=target&&nums[mid]>target){
//                    high=mid-1;
//                }else {
//                    low = mid+1;
//                }
//            }else {
//                if(nums[mid]<target&&nums[length-1]>=target){
//                    low = mid+1;
//                }else {
//                    high=mid-1;
//                }
//            }
//
//        }
//    return -1;
//    }

}
