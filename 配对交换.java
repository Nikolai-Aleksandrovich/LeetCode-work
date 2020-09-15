package com.itranswarp.sample;

public class Solution1 {
    public int exchangeBits(int num) {
        int odd = num&0x55555555;//0b0101 0101 0101 0101 0101 0101
        int even = num&0xaaaaaaaa;//0b1010 1010 1010 1010
        odd = odd<<1;
        even = even>>>1;
        return odd|even;
    }
}
