package com.itranswarp.sample;

public class Solution {
    public int numRookCaptures(char[][] board) {
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(board[i][j]=='R'){
                   int res = 0;
                   for(int[] direction:directions){
                       if(burnout(board,i,j,direction)){
                           res++;
                       }
                   }
                   return res;
                }
            }

        }
        return 0;
    }
    private boolean burnout(char[][] board,int x,int y,int[] direction){
        int i=x;
        int j=y;
        while (inArea(i,j)){
            if(board[i][j]=='B'){
                break;
            }
            if(board[i][j]=='p'){
                return true;
            }
            i += direction[0];
            j += direction[1];
        }
        return false;
    }
    private boolean inArea(int i,int j){
        if(i<8&&i>=0&&j<8&&j>=0){
            return true;
        }
        return false;
    }
}
