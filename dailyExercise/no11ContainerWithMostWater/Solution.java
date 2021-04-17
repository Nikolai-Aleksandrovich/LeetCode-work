package no11ContainerWithMostWater;

/**
 * @author Yuyuan Huang
 * @create 2021-04-17 17:52
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height==null||height.length==0||height.length==1){
            return 0;
        }
        int head = 0;
        int end = height.length-1;
        int curMax = 0;
        int length =0;
        int high = 0;
        int DL = 0;
        int DR = 0;
        while(head<end){
            high = Math.min(height[head],height[end]);
            length = end-head;
            curMax = Math.max(high*length,curMax);
            if (height[head]<height[end]){
                head = head+1;
            }else {
                end = end-1;
            }

        }
        return curMax;


    }
}
