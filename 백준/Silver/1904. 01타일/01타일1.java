import java.util.*;
import java.io.*;

public class Main{
    public static int[] dp= new int[1000001];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<dp.length; i++){
            dp[i]=-1;
        }
        System.out.print(tile(N));
    }
    public static int tile(int v){
        if(dp[v]== -1){
            return dp[v]=(tile(v-1)+tile(v-2))% 15746;
        }
        return dp[v];
    }
    
}
