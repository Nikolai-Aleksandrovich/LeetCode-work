package no28implementStrstr;

/**
 * @author Yuyuan Huang
 * @create 2021-03-23 17:23
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        int pointer1 = 0;
        int pointer2 = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if(needle.charAt(pointer1)==haystack.charAt(i)){
                pointer1++;
                if(pointer1==needle.length()){
                    return haystack.length()-pointer1;
                }
            }else {
                i=i-pointer1;
                pointer1=0;
            }
        }
        return 0;
    }
}
