import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] right = new int[n];
        int[] left = new int[n];
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
           left[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            right[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][n+1];
        for(int i = n-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]);

                if(left[i] > right[j]){
                    dp[i][j] = Math.max(dp[i][j+1]+right[j], dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[0][0]);

    }
}