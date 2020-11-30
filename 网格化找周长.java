package com.itranswarp.sample;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        for(int r=0;r<grid.length;r++){
            for (int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    return dfs(grid,r,c);
                }
            }
        }
        return 0;

    }
    private int dfs(int[][] grid,int r,int c){
        //网格边界
        if(!(r>=0&&r<grid.length&&c>=0&&c< grid[0].length)){
            return 1;
        }
        // 从一个岛屿方格走向水域方格，周长加 1
        if(grid[r][c]==0){
            return 1;
        }
        //==2的情形
        if(grid[r][c]!=1){
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid,r+1,c)+dfs(grid,r-1,c)+dfs(grid,r,c+1)+dfs(grid,r,c-1);

    }
}
