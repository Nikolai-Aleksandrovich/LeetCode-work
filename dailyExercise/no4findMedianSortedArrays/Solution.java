package no4findMedianSortedArrays;

/**
 * @author Yuyuan Huang
 * @create 2021-03-28 16:50
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    }
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if(nums1.length==0){
//            if(nums2.length%2==1){
//                return nums2[nums2.length/2];
//            }else {
//                float jump = (nums2[nums2.length/2]+nums2[nums2.length/2-1]);
//                return jump/2;
//            }
//        }
//        if(nums2.length==0){
//            if(nums1.length%2==1){
//                return nums1[nums1.length/2];
//            }else {
//                float jump = (nums1[nums1.length/2]+nums1[nums1.length/2-1]);
//                return jump/2;
//            }
//        }
//        int realLength = nums1.length+nums2.length;
//        boolean isDouble = true;
//        if (realLength%2==1){
//            isDouble=false;
//        }
//        float firstJump;
//        float secondJump;
//        int curLength = 0;
//        int point1= 0;
//        int point2 =0;
//        while (curLength!=realLength/2-1){
//            int num1Value;
//            int num2Value;
//            if(nums1.length==point1){
//                num1Value=Integer.MAX_VALUE;
//            }else {
//                num1Value=nums1[point1];
//            }
//            if(nums2.length==point2){
//                num2Value=Integer.MAX_VALUE;
//            }else {
//                num2Value=nums2[point2];
//            }
//
//            if(num1Value<num2Value){
//                point1++;
//                curLength++;
//            }else{
//                point2++;
//                curLength++;
//            }
//        }
//        System.out.println("1p"+point1+"2p"+point2+"le"+curLength);
//        if(point1== nums1.length){
//            firstJump=nums2[point2];
//            secondJump=nums2[point2+1];
//
//        }else if(point2== nums2.length){
//            firstJump=nums1[point1];
//            secondJump=nums1[point1+1];
//
//        }else {
//            if(nums1[point1]>=nums2[point2]){
//                firstJump=nums2[point2];
//                if(point2+1==nums2.length){
//                    secondJump=nums1[point1];
//                }else {
//                    secondJump=Math.min(nums1[point1],nums2[point2+1]);
//                }
//            }else {
//                firstJump=nums1[point1];
//                if(point1+1==nums1.length){
//                    secondJump=nums2[point2];
//                }else {
//                    secondJump=Math.min(nums1[point1+1],nums2[point2]);
//                }
//            }
//        }
//        System.out.println("F"+firstJump+"s"+secondJump);
//
//        if (isDouble){
//            return (secondJump+firstJump)/2;
//        }else {
//            return secondJump;
//        }
//
//
//    }
}
