import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        int[][] arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j<=i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N+1][N+1];
        dp[1][1] = arr[1][1];
        for(int i = 2; i <= N; i++){
            for(int j = 1; j<=i; j++){
                if(j==1) dp[i][j] += dp[i-1][j]+arr[i][j];
                else if(j==i) dp[i][j] += dp[i-1][j-1]+arr[i][j];
                else dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }
        int max = 0;
        for(int i = 1; i <= N; i++){
            max = Math.max(max, dp[N][i]);
        }
        System.out.println(max);
    }
}
