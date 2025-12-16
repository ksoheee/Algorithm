import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] agrs)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] rgb = new int[N][3];
        int[][] dp = new int[N][3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            rgb[i][0] =  Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];
        for(int i=1; i<N; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+rgb[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+rgb[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+rgb[i][2];
        }
        System.out.println(Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2])));

    }

}