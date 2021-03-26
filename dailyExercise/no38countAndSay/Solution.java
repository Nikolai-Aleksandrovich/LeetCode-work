package no38countAndSay;

/**
 * @author Yuyuan Huang
 * @create 2021-03-26 16:46
 */
public class Solution {
    public String countAndSay(int n) {
        if(n==0) {
            return "0";
        }
        if(n==1){
            return "1";
        }
        if(n==2){
            return "21";
        }
        String temp = countAndSay(n-1);
        System.out.println(temp);
        StringBuilder  stringBuilder = new StringBuilder();
        int  second=0;
        int  first = 0;
        while (first<temp.length()) {
            if(temp.charAt(second)==temp.charAt(first)){
                first++;
                if (first==temp.length()){
                    stringBuilder.append(first-second).append(temp.charAt(second));
                    return stringBuilder.toString();
                }
            }else {
                stringBuilder.append(first-second).append(temp.charAt(second));
                second=first;
            }
        }
        System.out.println("n"+n+"String"+stringBuilder);
        return stringBuilder.toString();
    }
}
