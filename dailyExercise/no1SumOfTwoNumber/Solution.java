package dailyExercise.no1SumOfTwoNumber;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yuyuan Huang
 * @create 2021-03-16 20:14
 */
public class Solution {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{i, hashMap.get(target-nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }
}
