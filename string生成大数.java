public class Solution {
    StringBuilder res;
    char[] nums,loop = {'0','1','2','3','4','5','6','7','8','9'};
    int count = 0,n;
    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder();
        nums=new char[n];
        dfs(0);
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
    void dfs(int x){
        if(x==n){
            res.append(String.valueOf(nums)+",");
        }
        for(char i:loop){
            nums[x]=i;
            dfs(x+1);
        }
    }

}
