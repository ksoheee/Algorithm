import java.util.*;
import java.io.*;
public class Main {
    static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        
        
        for(int i=0; i<num; i++){
           st = new StringTokenizer(br.readLine()," ");
           int n = Integer.parseInt(st.nextToken());
           int k = Integer.parseInt(st.nextToken());
           dp = new int[k+1][n+1];
           System.out.println(bc(k,n));
        }
    }
    static int bc(int n, int k){
        if(dp[n][k]>0){
            return dp[n][k];
        }
        if(n==k|| k==0){
            return dp[n][k]=1;
        }
        return dp[n][k]=bc(n-1,k-1)+bc(n-1,k);
    }
}
