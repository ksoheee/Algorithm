import java.util.*;
import java.io.*;

public class Main{
    static int[] coins;
    static int[] dp;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        coins = new int[n];
        dp = new int[k+1];
        for(int i=0; i<n; i++){
           coins[i]= Integer.parseInt(br.readLine());
        }
        
        Arrays.fill(dp, 100001);
        dp[0]=0; //0원을 만드는 개수는 0개이므로
        for(int coin : coins){
            for(int m = coin; m<=k; m++){
                //m원을 만드는 기존 최소 동전 개수와, 현재금액에서-coin을 뺀 금액의 최소 동전 개수와 coin1개를 더한 개수 중 작은 값
                dp[m] = Math.min(dp[m],dp[m-coin]+1);
            }
        }
        System.out.println(dp[k]==100001 ? -1 : dp[k]);   
    }
}
