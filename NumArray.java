package com.itranswarp.sample;

import java.util.HashMap;
import java.util.Map;

class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
    }
    public int sumRange(int i,int j){
        return sum[j+1]-sum[i];
    /**
     * 这个方法使用很多的额外空间，但可以优化
     *
     * private Map<Pair<Integer,Integer>,Integer> map = new HashMap<>();
     *     public NumArray(int[] nums) {
     *         for (int i=0;i< nums.length;i++) {
     *             int sum = 0;
     *             for (int j = i; j < nums.length; j++) {
     *                 sum += nums[j];
     *                 map.put(Pair.create(i, j), sum);
     *             }
     *         }
     *     }
     *     public int sumRange(int i,int j) {
     *         return map.get(Pair.create(i, j));
     *     }
     */

    /**
     * private int[] data;
     */
    /**
     * 这个方法会超时，可以用一种空间换时间的方法
     * public NumArray(int[] nums) {
     *         data=nums;//data其实是一个对nums的引用，并不会额外占用N的空间
     *     }
     * @param nums
     */
    /**
     * //如果这个sumRange被调用太多，不如直接提前计算
     * public int sumRange(int i, int j) {
     *         int ans = 0;
     *         for(int k=i;k<j+1;k++){
     *             ans += data[k];
     *         }
     *         return ans;
     *}
     * @param i
     * @param j
     * @return
     */

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */