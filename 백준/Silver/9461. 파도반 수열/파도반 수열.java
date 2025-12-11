import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] dp;
        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine()); 
            dp = new long[m+1];
            
            if(m<=3){
                System.out.println(1);
                continue;
            }
            dp[1]=1; dp[2]=1; dp[3]=1;
            for(int j=4; j<=m; j++){
                dp[j] = dp[j-2]+dp[j-3];
            }
            System.out.println(dp[m]);
        }
    }
}