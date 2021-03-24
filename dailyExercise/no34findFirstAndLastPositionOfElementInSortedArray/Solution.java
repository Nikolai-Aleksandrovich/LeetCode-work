package no34findFirstAndLastPositionOfElementInSortedArray;

/**
 * @author Yuyuan Huang
 * @create 2021-03-23 23:33
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int low = 0;
        int high = nums.length-1;
        while (low<=high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid]==target){
                if(mid==low){
                    start=mid;
                }else {
                    if(nums[mid-1]==target){
                    start=headCal(nums,low,mid-1,target);
                    }else {
                        start=mid;
                    }
                }
                if(mid == high){
                    end=mid;
                    return new int[]{start,end};
                }else {
                    if(nums[mid+1]==target){
                        end=tailCal(nums,mid+1,high,target);
                        return new int[]{start,end};
                    }else {
                        end=mid;
                        return new int[]{start,end};
                    }
                }

            }else if(nums[mid]>target){
                high=mid-1;
            }else {
                low=mid+1;
            }


        }


        return new int[]{start,end};

    }
    private int headCal(int[] nums,int low,int high,int target){
        while(low<=high){
            if(high==low){
                return low;
            }
            int mid = (high-low)/2+low;
            if(nums[mid]!=target){
                low=mid+1;
            }else {
                if(nums[mid-1]==target){
                    high=mid-1;
                }else {
                    return mid;
                }

            }
        }
        return -1;
    }
    private int tailCal(int[] nums,int low,int high,int target){
        while (low<=high){
            if(high==low){
                return low;
            }
            int mid = (high-low)/2+low;
            if(nums[mid]!=target){
                high=mid-1;
            }else {
                if(nums[mid+1]==target){
                    low=mid+1;
                }else {
                    return mid;
                }

            }
        }
        return -1;
    }
}
