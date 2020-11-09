package com.itranswarp.sample.contest;

import java.util.Arrays;
import java.util.Scanner;

public class Pass16into10 {
    public int transformer(String s){
            int r=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    r+=(s.charAt(i)-'0')*(Math.pow(16, s.length()-i-1));
                }else if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                    r+=(s.charAt(i)-'a'+10)*(Math.pow(16, s.length()-i-1));
                }else if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                    r+=(s.charAt(i)-'A'+10)*(Math.pow(16, s.length()-i-1));
                }
            }
            return r;

    }
}
