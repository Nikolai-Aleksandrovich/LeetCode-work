public class Solution {
    //给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
    //
    //如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/count-good-triplets

    public int countGoodTriplets(int[] arr, int a, int b, int c) {


        int count = 0;
        for(int i = 0;i<arr.length-2;i++){
            for(int j = i+1;j<arr.length-1;j++){
                for(int k = j+1;k<arr.length;k++){
                    boolean issmallerA = false;
                    boolean issmallerB = false;
                    boolean issmallerC = false;
                    int prevsA = Math.abs(arr[i]-arr[j]);
                    int prevsB = Math.abs(arr[j]-arr[k]);
                    int prevsC = Math.abs(arr[i]-arr[k]);
                    issmallerA = prevsA<=a;
                    issmallerB = prevsB<=b;
                    issmallerC = prevsC<=c;
                    if(issmallerA&&(issmallerB&&issmallerC)){
                        count++;
                    }

                }
            }

        }
        return count;

    }

}
