package com.itranswarp.sample;

public class Solut8ion {
    public int titleToNumber(String s) {
        int length = s.length();
        int ans = 0;
        for (int i=length-1;i>=0;i--){
            ans= (int) (ans+Math.pow(26,i)*((int)(s.charAt(length-i-1))-64));
        }
        return ans;

    }
}
