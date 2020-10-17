package com.itranswarp.sample;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        //其实不必要使用list
        int ptr = 0,n=s.length(),last=0,ans=0;
        while (ptr<n){
            char c = s.charAt(ptr);
            int count = 0;
            while(ptr<n&&s.charAt(ptr)==c){
                ptr++;
                count++;
            }
            ans+=Math.min(count,last);
            last=count;
        }
        return ans;
    }

    /**
     *
     * @param s
     * @return
     */
    /*public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int ptr = 0, n = s.length();
        while(ptr<n){
            char c = s.charAt(ptr);
            int count = 0;
            while(ptr<n&&s.charAt(ptr)==c){
                count++;
                ptr++;
            }
            list.add(count);
        }
        int ans = 0;
        for (int i=1;i< list.size();i++){
            ans+=Math.min(list.get(i),list.get(i-1));
        }
        return ans;
    }
    */

    /*public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int count =1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                count+=1;
            }else {
                list.add(count);
                count=1;
            }
        }
        int contribute = 0;
        for (int i=0;i<list.size()-1;i++){
            contribute=+Math.min(list.get(i),list.get(i+1));
        }
        return contribute;
    }
    */

    /*
    public int countBinarySubstrings(String s) {

        int count = 0;
        for (int i=0;i<s.length();i++){
            int value = 0;
            for (char c:s.substring(i).toCharArray()){
                if(c=='0'){
                    value-=1;
                }else {
                    value+=1;
                }
                if(value==0){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    */
}
