package dailyExercise.no88MergeSortedArray;

/**
 * @author Yuyuan Huang
 * @create 2021-03-17 10:57
 * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 *
 * src:源数组;
 *
 * srcPos:源数组要复制的起始位置;
 *
 * dest:目的数组;
 *
 * destPos:目的数组放置的起始位置;
 *
 * length:复制的长度.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        System.arraycopy(nums1,0,nums3,0,m);
        int p2 = 0;
        int p3 = 0;
        int p = 0;
        while (p2<n && p3<m){
            nums1[p++] = (nums3[p3]<nums2[p2])? nums3[p3++]:nums2[p2++];

        }
        if(p3<m){
            System.arraycopy(nums3,p3,nums1,p2+p3,m+n-p2-p3);
        }
        if(p2<n){
            System.arraycopy(nums2,p2,nums1,p2+p3,m+n-p2-p3);
        }

    }
}
