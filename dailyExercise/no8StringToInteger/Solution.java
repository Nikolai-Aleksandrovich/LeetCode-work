package no8StringToInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-03-19 10:52
 */
public class Solution {
    public int myAtoi(String str){
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);

    }


}
class Automaton{
    public int sign =1;
    //默认为正数
    public long ans = 0;
    //排除符号的答案
    private String state = "start";
    //当前状态为启动(start,signed,in_number,end)
    private Map<String,String[]> table = new HashMap<String,String[]>(){
        {
            put("start",new String[]{"start","signed","in_number","end"});
        put("signed",new String[]{"end","end","in_number","end"});
        put("in_number",new String[]{"end","end","in_number","end"});
        put("end",new String[]{"end","end","end","end"});

        }
    };
    //构建一个映射表
    public void get(char c){
        state = table.get(state)[get_col(c)];
        //依靠当前状态和当前字母状态计算出当前状态
        if("in_number".equals(state)){
            ans = ans*10+c-'0';
            //ans+c-'0'可以利用ascii码得到数字，0->48,1->49,1-0=49-48=1;
            ans = sign==1? Math.min(ans,(long)Integer.MAX_VALUE) : Math.min(ans,(long)-Integer.MIN_VALUE);
            //假如超过int的边界，那么取最小值
        }else if("signed".equals(state)){
            sign = c == '+' ? 1:-1;
        }
    }
    private int get_col(char  c){
        if(c==' '){
            return 0;
        }
        if (c=='+'||c=='-'){
            return 1;
        }
        if(Character.isDigit(c)){
            return 2;
        }
        else return 3;
    }


}