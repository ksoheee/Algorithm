import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k+1];
        Arrays.fill(dp,INF);
        dp[0]=0;

        for(int coin : coins){
            for(int money = coin; money <= k; money++){
                dp[money] = Math.min(dp[money], dp[money-coin]+1);
            }
        }
        System.out.println(dp[k]==INF?-1:dp[k]);

    }
}
