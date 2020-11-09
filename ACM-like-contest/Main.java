package com.itranswarp.sample.contest;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
//        System.out.println(s1);
        String s2 = scanner.nextLine();
//        System.out.println(s2);
        String hex= Integer.toHexString(transformer(s1)+ transformer(s2));
        System.out.println(hex);
    }
    public static int transformer(String s){
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
