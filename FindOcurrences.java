package com.itranswarp.sample;

import java.util.ArrayList;
import java.util.List;

public class FindOcurrences {
    public String[] findOcurrences(String text, String first, String second) {
        String[] pool = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i=0;i<pool.length-2;i++){
            if(pool[i].equals(first)){
                if(pool[i+1].equals(second)){
                    list.add(pool[i+2]);
                }
            }
        }
//        String[] ans = new String[list.size()];
//        int a = 0;
//        for (String element:list){
//            ans[a++]=element;
//        }
        return list.toArray(new String[0]);

}
}
