public class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder ans = new StringBuilder();
        int start = 0;
        int end = 0;
        int count = 0;
        boolean flag = false;
        for(int i = 0; i<S.length();i++){
            char ch = S.charAt(i);
            if(ch == '('){
                count++;
                if(!flag){
                    start=i;
                    flag = true;
                }

            }else
                count--;
                if(count==0){
                    end = i;
                    flag=false;
                    ans.append(S.substring(start+1,end));
                    start=end;

                }


        }
        return ans.toString();
    }
}
