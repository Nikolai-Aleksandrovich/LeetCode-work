package no5longestPalindromicSubstring;

/**
 * @author Yuyuan Huang
 * @create 2021-04-17 13:10
 */
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len<2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        //初始化，所有长度为一的都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
        }

        char[] charArray = s.toCharArray();
        //先枚举子串长度
        for (int L = 2; L <=len; L++) {
            //枚举左边界
            for (int i = 0; i < len; i++) {
                //由L和i确定右边界     j-i+1 = L
                int j = L+i - 1;
                //右边界越界
                if (j>=len){
                    break;
                }
                if(charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else {
                    if (j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j]&&(j-i+1)>maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);

    }
    private String subString(String s){
        if(s==null || s.length()==0){
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i<s.length();i++){
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len>end-start){
//                start = i
            }

        }
        return  s;
    }
    private int expandAroundCenter(String s,int left,int right){
        while (left>0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
