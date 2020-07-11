package com.pratiace.fristpackage;
//给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
//
//        所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
public class Solution {
    public String defangIPaddr(String address) {

//        replace函数直接使用
//        return address.replace(".","[.]");

//        //使用Stringbuilder.append会比直接replace快一些
            //StringBuilder.insert也可以
//        StringBuilder IP = new StringBuilder();
//        for(int i=0;i<address.length();i++){
//            if(address.charAt(i) == '.'){
//                IP.append("[.]");
//                continue;
//
//            }
//            IP.append(address.toCharArray()[i]);
//        }
//        return IP.toString();

    }
}
