package offer13robotMoving;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yuyuan Huang
 * @create 2021-04-17 16:10
 */
public class Solution {
    public int movingCount(int m, int n, int k) {
        if (k==0){
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0,1};
        int[] dy = {1,0};
        //方向矩阵
        boolean[][] vis = new boolean[m][n];
        //TF矩阵
        queue.offer(new int[]{0,0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()){
            //只要不空
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            for (int i = 0; i < 2; i++) {
                int tx = dx[i]+x;
                int ty = dy[i]+y;
                if (tx<0||tx>=m||ty<0||ty>=n||vis[tx][ty]||get(tx)+get(ty)>k){
                    continue;
                }
                queue.offer(new int[]{tx,ty});
                //当前队列取出的数组，x不变y+1，y不变，x+1，符合数组边界要求，且没有记录过，且符合总数要求
                //只要能加入队列，那么一定是符合要求的
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }
    private int get(int x){
        int res = 0;
        while (x!=0){
            res+=x%10;
            x/=10;
        }
        return res;
    }
    private int mySolution(int m, int n, int k){
        if(k==0){
            return 1;
        }

        boolean[][] dp = new boolean[m][n];
        int result = 1;
        dp[0][0]=true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (get(i)+get(j)>k||(i==0&&j==0)){
                }else{
                    if (i-1>=0){
                        dp[i][j]=dp[i-1][j];
                    }
                    if(j-1>=0){
                        dp[i][j]=dp[i][j-1];
                    }
                    result= dp[i][j]? result+1:result;
                }
            }
        }
        return result;
    }
}
