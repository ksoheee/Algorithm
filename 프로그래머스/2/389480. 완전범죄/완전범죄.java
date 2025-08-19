import java.util.*;
class Solution {
    public static int[][] dp;
    static final int INF = 100000;
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        dp = new int[info.length+1][m];
        for(int i=0; i<=info.length; i++){
            Arrays.fill(dp[i],INF);
        }
        dp[0][0]=0;
        for(int i=1; i<=info.length; i++){
            int a = info[i-1][0];
            int b = info[i-1][1];
            for(int j=0; j<m; j++){
                //a
                dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+a);
                //b
                if(b+j<m)
                    dp[i][j+b]=Math.min(dp[i-1][j],dp[i][j+b]);
                }

        }
        int min = INF;
        for(int i=0; i<m; i++){
            min= Math.min(dp[info.length][i],min);
        }
        return min>=n? -1: min;
    }

}