package dailyExercise.no3LengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Yuyuan Huang
 * @create 2021-03-16 22:39
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int right = s.length();
        int length = s.length();
        int left = -1;
        int ans = 0;
        for (int i = 0; i < s.length() ; i++) {
            if(i!=0){
                hashSet.remove(s.charAt(left));
            }
            while(left+1<length&&!hashSet.contains(s.charAt(i))){
                hashSet.add(s.charAt(i));
                left++;
            }
            ans = Math.max(ans,left-i+1);

        }
        return ans;
    }
}
