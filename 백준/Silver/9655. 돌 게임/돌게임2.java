import java.util.*;
import java.io.*;
public class Main {   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        
        int[] dp = new int[M+1];
        dp[1]=1;
        if(M>=2) dp[2]=2;
        if(M>=3) dp[3]=1;
        
        for(int i=4; i<=M; i++){
            dp[i]= Math.min(dp[i-1],dp[i-3])+1;
        }
        System.out.println(dp[M]%2==1? "SK" : "CY");
    }
}
