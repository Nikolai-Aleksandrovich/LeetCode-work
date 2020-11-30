package com.itranswarp.sample;

public class Solution {
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0,1,0,-1};
        int[] dc = new int[]{1,0,-1,0};
        int N = grid.length;
        int ams = 0;
        for (int r = 0;r < N; ++r){
            for (int c = 0;c < N; ++c){
                if(grid[r][c] > 0){
                    ams += 2;
                    for (int k = 0;k < 4;++k){
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if(0 <= nr&& nr <N&&0<nc&&nc<N){
                            nv = grid[nr][nc];
                        }
                        ams+=Math.max(grid[r][c]-nv,0);
                    }
                }
            }
        }
        return ams;
    }

    /**
     * public int surfaceArea(int[][] grid) {
     *         int up = 0;
     *         int[] colMax = new int[grid[0].length];
     *         int[] rowMax = new int[grid.length];
     *         for(int i=0;i<grid.length;i++){
     *             for (int j=0;j<grid[0].length;j++){
     *                 if(grid[i][j]!=0){
     *                     up++;
     *                 }
     *                 if(grid[i][j]>rowMax[i]){
     *                     rowMax[i] = grid[i][j];
     *                 }
     *                 if(grid[j][i]>colMax[i]){
     *                     colMax[i] = grid[j][i];
     *                 }
     *
     *             }
     *         }
     *         int sum = 0;
     *         for(int element:colMax){
     *             sum+=element;
     *         }
     *         for (int element:rowMax){
     *             sum+=element;
     *         }
     *         return 2*(sum+up);
     *     }
     * @param grid
     * @return
     */

}
