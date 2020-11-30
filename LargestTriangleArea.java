package com.itranswarp.sample;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        int N = points.length;
        for(int i=0;i<N;i++){
            for (int j=i;j<N;j++){
                for (int k=j;k<N;k++){
                    ans=Math.max(ans,area(points[i],points[j],points[k]));
                }
            }
        }
        return ans;
    }
    private double area(int[] first,int[] second,int[] third){
        return 0.5*Math.abs(first[0]*second[1]+first[1]*third[0]+second[0]*third[1]-first[1]*second[0]-first[0]*third[1]+second[1]*third[0]);

    }
}
