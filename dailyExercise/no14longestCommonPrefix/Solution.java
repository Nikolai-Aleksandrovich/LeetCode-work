package no14longestCommonPrefix;

import java.util.HashSet;

/**
 * @author Yuyuan Huang
 * @create 2021-03-20 21:03
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int minLength = 200;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength,strs[i].length());
        }

        int low = 0;
        int high = minLength;
        while(low<high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0,low);

    }
    public boolean isCommonPrefix(String[] strs,int length){
        String str0 = strs[0].substring(0,length);
        int count =strs.length;
        for (int i = 0; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if(str0.charAt(j)!=str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

//    public String longestCommonPrefix(String[] strs) {
//        if(strs==null||strs.length==0){
//            return "";
//        }else {
//            return longestCommonPrefix(strs,0,strs.length-1);
//        }
//    }
//    private String longestCommonPrefix(String[] strs,int start,int end){
//        if(start == end){
//            return strs[start];
//        }else {
//            int mid = (end-start)/2+start;
//            String left = longestCommonPrefix(strs,0,mid);
//            String right = longestCommonPrefix(strs,mid+1,end);
//            return commonPrefix(left,right);
//
//        }
//    }
//    private String commonPrefix(String left,String right){
//        int length = Math.min(left.length(),right.length());
//        for (int i = 0; i < length; i++) {
//            if(left.charAt(i)!=right.charAt(i)){
//                if(i==0){
//                    return "";
//                }
//                return left.substring(0,i);
//            }
//        }
//        return left.substring(0,length);
//    }
//    public String longestCommonPrefix(String[] strs) {
//        if(strs==null ||strs.length==0){
//            return "";
//        }
//        int listLength = strs.length;
//        int minLength = 200;
//        for (String str : strs) {
//            minLength = Math.min(minLength, str.length());
//        }
//        int prefix = 0;
//        for (int i = 0; i < minLength; i++) {
//            for (int j = 1; j < listLength; j++) {
//                if(strs[0].charAt(i)!=strs[j].charAt(i)){
//                    if(prefix==0){
//                        return "";
//                    }
//                    return strs[0].substring(0,prefix);
//                }
//            }
//            prefix++;
//        }
//        return strs[0].substring(0,prefix);
//
//    }

//    public String longestCommonPrefix(String[] strs) {
//        if(strs==null||strs.length==0){
//            return "";
//        }
//        String prefix = strs[0];
//        int count = strs.length;
//        for (int i = 1; i < count; i++) {
//            prefix = longestCommonPrefix(prefix,strs[i]);
//            if(prefix.length()==0){
//                return "";
//            }
//        }
//        return prefix;
//
//    }
//    private String longestCommonPrefix(String s,String s2){
//        int length = Math.min(s.length(),s2.length());
//        int index = 0;
//
//        for (int i = 0; i<length;i++){
//            if(s.charAt(index)==s2.charAt(index)){
//                index++;
//            }else {
//                break;
//            }
//        }
//        return s.substring(0,index);
//    }
}
