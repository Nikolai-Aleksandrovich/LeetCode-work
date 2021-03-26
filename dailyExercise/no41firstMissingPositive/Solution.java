package no41firstMissingPositive;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

import static java.util.Arrays.stream;

/**
 * @author Yuyuan Huang
 * @create 2021-03-26 17:42
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int pCount = 0;
        if (nums.length==1){
            return nums[0]==1 ? 2:1 ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                exchange(nums,nums[i],nums[i]-1,i);
                nums[nums[i]-1]=nums[i];
            }
        }
        if (nums[0]!=1){
            return 1;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1]-nums[i]!=1){
                return i+2;
            }
        }

        return 0;

    }
    private void exchange(int[] nums,int curValue,int destIndex,int origin){
        if(curValue==nums[destIndex]){
            return;
        }
        int temp = nums[destIndex];
        nums[destIndex]=curValue;
        if (temp>0){
            exchange(nums,temp,temp-1,origin);
        }else {
            nums[origin]=temp;
        }
    }
//    public int firstMissingPositive(int[] nums) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int element:nums) {
//            if (element>0){
//                hashSet.add(element);
//            }
//        }
//        int length = hashSet.size();
//        for (int i = 1; i < length+2; i++) {
//            if (!hashSet.contains(i)){
//                return i;
//            }
//        }
//        return 0;
//    }
//    public int firstMissingPositive(int[] nums) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i]>0){
//                priorityQueue.add(nums[i]);
//            }
//        }
//        while (!priorityQueue.isEmpty()){
//            if (priorityQueue.peek()!=1){
//                return 1;
//            }
//            if (priorityQueue.size()==1){
//                return priorityQueue.peek()+1;
//            }
//            int smaller = priorityQueue.poll();
//            int small = priorityQueue.peek();
//            if(small!=smaller){
//                if(small-smaller!=1){
//                    return smaller+1;
//                }
//            }
//
//
//
//        }
//        return 0;

//    }
}
