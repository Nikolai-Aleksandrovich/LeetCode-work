package no443stringCompression;

/**
 * @author Yuyuan Huang
 * @create 2021-04-22 18:57
 */
public class Solution {
    public int compress(char[] chars) {

        int length = chars.length;
        if (length==1){
            return 1;
        }
        if (length==0){
            return 0;
        }
        int head = 0;
        int curLength = 1;
        int neck = head+1;
        for (int i = 1; i < length; i++) {
            if (chars[i-1]==chars[i]){
                curLength++;
            }else {
                chars[head]=chars[i-1];
                if (curLength==1){
                    head++;
                    neck++;
                }else {
                    int count = 0;
                    for (char c:String.valueOf(curLength).toCharArray()
                         ) {
                        chars[neck] = c;
                        count++;
                    }
                    head=head+count+1;
                    neck=head+1;
                }
                curLength=1;

            }
        }
        chars[head]=chars[length-1];
        if (curLength!=1){
            for (char c:String.valueOf(curLength).toCharArray()
            ) {
                chars[neck] = c;

            }
        }
        return head+1;
    }
}
