package no15threeSum;

import java.util.*;

/**
 * @author Yuyuan Huang
 * @create 2021-03-21 16:13
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        for(int first = 0; first<length;first++){
            if(first!=0 && nums[first]!=nums[first-1]){
                continue;
            }
            int third = length-1;
            int target = -nums[first];
            for (int second = first+1;second<length;second++){
                if(second!=first+1 && nums[second]==nums[second-1]){
                    continue;
                }
                while (second<third && nums[second]+nums[third]>target){
                    third--;
                }
                if(second==third){
                    break;
                }
                if(nums[second]+nums[third]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[second] );
                    list.add(nums[third] );
                    list.add(nums[first] );
                    ans.add(list);
                }
            }
        }
        return ans;



    }
}
