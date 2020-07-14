package com.pratiace.fristpackage;
//平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
//
//你可以按照下面的规则在平面上移动：
//
//每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
//必须按照数组中出现的顺序来访问这些点。
//

public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {


            int count = 0;
            int curX = 0;
            int curY = 0;
            int nextX = 0;
            int nextY = 0;

            int[] currentPoint = points[0];
            curX = currentPoint[0];
            curY = currentPoint[1];
            for(int[] point:points){

                nextX = point[0];
                nextY = point[1];
                if(Math.abs(nextX-curX) == Math.abs(nextY-curY)){
                    count += Math.abs(curX-nextX);
                }else {
                    count += Math.max(Math.abs(nextX-curX),Math.abs(Math.abs(nextY-curY)));
                }
                curX = nextX;
                curY = nextY;


            }




        return  count;

    }
}
