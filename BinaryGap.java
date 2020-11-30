package com.itranswarp.sample;

public class BinaryGap {
    public int binaryGap(int n) {
        int[] pool = new int[32];
        int t=0;
        for (int i=0;i<32;i++){
            if(((n>>i)&1)==1){
                pool[t++]=i;
            }
        }
        int ans = 0;
        for (int i=0;i<t-1;++i){
            ans = Math.max(ans,pool[i+1]-pool[i]);
        }
        return ans;

    /*public int binaryGap(int n) {
        int last = -1;
        int ans = 0;
        for(int i=0;i<32;i++){
            if(((n>>i)&1)>0){
                if(last>=0){
                    ans = Math.max(ans,i-last);
                }
                last = i;
            }
        }
        return ans;*/

    }
}
