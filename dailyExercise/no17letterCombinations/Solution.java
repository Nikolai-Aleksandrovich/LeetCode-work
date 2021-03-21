package no17letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-03-21 17:34
 */
public class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(2,"abc");
        hashMap.put(3,"def");
        hashMap.put(4,"ghi");
        hashMap.put(5,"jkl");
        hashMap.put(6,"mno");
        hashMap.put(7,"pqrs");
        hashMap.put(8,"tuv");
        hashMap.put(9,"wxyz");
        backTracer(ans,digits,0,new StringBuilder(),hashMap);
        return ans;

    }
    private void backTracer(List<String> list,String digits,int index,StringBuilder stringBuilder,HashMap<Integer,String> hashMap){
        if(index == digits.length()){
            list.add(stringBuilder.toString());
        }else {
            String currentString = hashMap.get((int)digits.charAt(index));
            int length = currentString.length();
            for (int i = 0; i < length; i++) {
                stringBuilder.append(currentString.charAt(i));
                backTracer(list,digits,index+1,stringBuilder,hashMap);
                stringBuilder.deleteCharAt(index);
            }

        }

    }
}
