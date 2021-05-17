package binaryTree.no96uniqueBinarySearchTreesii;

/**
 * @author Yuyuan Huang
 * @create 2021-05-14 17:42
 */
class Solution {
//    public int numTrees(int n) {
//        return backTrace(1,n);
//
//    }
    public int numTrees(int n) {
        int[] pool = new int[n+1];
        pool[0] = 1;
        pool[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <=i ; j++) {
                pool[i] = pool[j-1]*pool[i-j];
            }
        }
        return pool[n];
    }
    private int backTrace(int start,int end){
        int totalNum = 0;
        if (start>end){
            return 0;
        }
        for (int i = start; i < end+1; i++) {
            int leftNum = backTrace(start,i-1);
            System.out.println(leftNum);

            int rightNum = backTrace(i+1,end);
            System.out.println(rightNum);
            if (leftNum==0&&rightNum==0){
                totalNum+=1;
            }else if (rightNum==0){
                totalNum+=leftNum;
            }else if (leftNum==0){
                totalNum+=rightNum;
            }else {
                totalNum += leftNum*rightNum;
            }
        }
        return totalNum;
    }
    private void
}