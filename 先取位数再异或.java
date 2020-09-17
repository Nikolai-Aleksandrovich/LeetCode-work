package com.itranswarp.sample;

import java.util.Map;

public class Solution {
    public int findComplement(int num) {
        int tem = num;
        int count = 0;
        while (tem!=0){
            count++;
            tem=tem>>1;
        }
        return ((1<<count)-1)^num;
    }
}
