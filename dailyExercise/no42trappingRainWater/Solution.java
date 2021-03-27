package no42trappingRainWater;

import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @author Yuyuan Huang
 * @create 2021-03-27 15:46
 */
public class Solution {
    public int trap(int[] height) {
        if (height==null||height.length==0){
            return 0;
        }
        int ans = 0;
        int[] temp1 = new int[height.length];
        temp1[0]=height[0];

        int[] temp2 = new int[height.length];
        temp2[height.length-1]=height[height.length-1];
        for (int i=1;i< height.length;i++){
            temp1[i] = Math.max(height[i],temp1[i-1]);
        }
        for (int i = height.length-2; i >=0 ; i--) {
            temp2[i]= Math.max(height[i],temp2[i+1]);
        }
        System.out.println(Arrays.toString(temp1));
        System.out.println(Arrays.toString(temp2));
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(temp1[i],temp2[i]);
            if(temp>height[i]){
                ans+=temp-height[i];
            }

        }
        System.out.println(ans);
        return ans;

    }
//    public int trap(int[] height) {
//        int ans = 0;
//        int length = height.length;
//        for (int i = 0; i < length; i++) {
//            int maxRight = 0;
//            int maxLeft = 0;
//            for (int j = i; j < length; j++) {
//                maxRight = Math.max(maxRight,height[j]);
//            }
//            for (int j = i; j >= 0; j--) {
//                maxLeft = Math.max(maxLeft,height[j]);
//            }
//            ans += (Math.min(maxLeft,maxRight)-height[i]);
//        }
//        return ans;
//    }

}
