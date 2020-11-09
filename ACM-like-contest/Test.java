package com.itranswarp.sample.contest;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);//请输入一个十六进制数
            String hexStr1 = sc.nextLine();
            String hexStr2 = sc.nextLine();//"请输入另一个十六进制数："
            String addRet = addHex(hexStr1.toUpperCase(),hexStr2.toUpperCase());
            System.out.println(addRet);//"结果为："
            break;
        }
    }

    private static String addHex(String hexStr1, String hexStr2) {
        String hexStr = "";
        //比较两个字符串的长度，通过交换位置保证第一个字符串比第二个长
        if(hexStr2.length() > hexStr1.length()) {
            hexStr = hexStr1;
            hexStr1 = hexStr2;
            hexStr2 = hexStr;
        }
        //将字符串变为字符数组
        char []hexChr1 = hexStr1.toCharArray();
        char []hexChr2 = hexStr2.toCharArray();
        Object addRet = "";
        int jingwei = 0;
        StringBuffer sb = new StringBuffer();
        //遍历字符数组
        for(int i = hexChr2.length-1;i >= 0;i--) {
            int flag2 = getInt(hexChr2[i]);
            int flag1;
            if(hexStr1.length() == hexStr2.length()) {
                flag1 = getInt(hexChr1[i]);
            }else {
                flag1 = getInt(hexChr1[i+hexStr1.length()-hexStr2.length()]);
            }
            int sum = flag1 + flag2 + jingwei;
            if(sum > 9 && sum < 16) {
                addRet = getHex(sum);
                jingwei = 0;
            } else if(sum >=16) {
                //如果相加的和大于等于16，求余并向前进位
                addRet = sum % 16;
                if((int)addRet > 9) {
                    addRet = getHex((int)addRet);
                }
                jingwei = 1;
            } else {
                addRet = sum;
                jingwei = 0;
            }
            sb.insert(0,addRet);
        }
        //如果两个字符串的长度不相等，计算多出来的那一段字符
        if(hexStr1.length() != hexStr2.length()) {
            for(int i=hexStr1.length()-hexStr2.length()-1;i>=0;i--) {
                if(jingwei == 1) {
                    int flag = getInt(hexChr1[i]);
                    addRet = flag+jingwei;
                    if((int)addRet > 9 && (int)addRet < 16) {
                        addRet = getHex((int)addRet);
                        jingwei = 0;
                    }else if((int)addRet >= 16){
                        addRet = (int)addRet % 16;
                        jingwei = 1;
                    }
                    sb.insert(0,addRet);
                } else {
                    sb.insert(0,hexChr1[i]);
                }
            }
        }
        //最后再判断进位，如果进位为1，再向前进一位
        if(jingwei == 1) {
            sb.insert(0,jingwei);
        }
        return sb.toString();
    }

    /**
     *   通过字符得到对应的十进制数
     * */
    private static int getInt(char chr) {
        int flag;
        switch(chr) {
            case 'A':
                flag = 10;
                break;
            case 'B':
                flag = 11;
                break;
            case 'C':
                flag = 12;
                break;
            case 'D':
                flag = 13;
                break;
            case 'E':
                flag = 14;
                break;
            case 'F':
                flag = 15;
                break;
            default:
                flag = Integer.parseInt(chr+"");
                break;
        }
        return flag;
    }

    /**
     * 通过十进制数得到对应的16进制字符
     * */
    private static char getHex(int i) {
        char c = 0;
        switch(i) {
            case 10:
                c = 'A';
                break;
            case 11:
                c = 'B';
                break;
            case 12:
                c = 'C';
                break;
            case 13:
                c = 'D';
                break;
            case 14:
                c = 'E';
                break;
            case 15:
                c = 'F';
                break;
        }
        return c;
    }
}