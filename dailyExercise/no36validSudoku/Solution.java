package no36validSudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-03-24 11:32
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               HashSet<Character> hashSet =  new HashSet<>();
               HashSet<Character> hashSet1 = new HashSet<>();
               char c = board[i][j];
               char a = board[j][i];
               if(c!='.'){
                   if(!hashSet.add(c)){
                       return false;
                   }
               }
               if(a!='.'){
                   if(!hashSet1.add(a)){
                       return false;
                   }
               }
            }
        }
        for (int i = 0; i <7; i++) {
            for (int j = 0; j < 7; j++) {
                HashSet<Character> hashSet = new HashSet<>();
                for (int k = 0; k < 2; k++) {
                        for (int l = 0; l < 2; l++) {
                        char a = board[i+k][j+l];
                        if(a!='.'){
                            if(!hashSet.add(a)){
                                return false;
                            }
                        }
                    }


                }
            }
        }
        return true;


    }
}
