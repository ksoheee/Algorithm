import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int val = Integer.parseInt(st.nextToken());

                if (i == 0) {
                    dp[i][j] = val;
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + val;
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + val;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + val;
                }
            }
        }

        int answer = 0;
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[n - 1][j]);
        }

        System.out.println(answer);
    }
}
