package no22generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-03-22 11:41
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrace(list,new StringBuilder(),0,0,n);
        return list;

    }
    private void  backTrace(List<String> list,StringBuilder sb,int open,int close,int max){
        if(sb.length()==max*2){
            list.add(sb.toString());
        }
        if(open<max){
            sb.append("(");
            backTrace(list,sb,open+1,close,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(")");
            backTrace(list,sb,open,close+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }
//    public List<String> generateParenthesis(int n) {
//        List<String> list = new ArrayList<>();
//        anyCombination(new char[2*n],0,list);
//        return list;
//
//    }
//    private void anyCombination(char[] current,int index,List<String> list){
//        if(current.length==index){
//            if(isValid(current)){
//                list.add(new String(current));
//            }
//        }else {
//            current[index] = '(';
//            anyCombination(current,index+1,list);
//            current[index]=')';
//            anyCombination(current,index+1,list);
//        }
//    }
//    private boolean isValid(char[] current){
//        int balance = 0;
//        for (char c : current) {
//            if (c == '(') {
//                balance++;
//            } else {
//                balance--;
//            }
//            if (balance < 0) {
//                return false;
//            }
//        }
//        return balance==0;
//    }

}
