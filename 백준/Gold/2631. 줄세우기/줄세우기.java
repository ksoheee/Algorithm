import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] line = new int[n];
        for(int i = 0; i < n; i++){
            line[i]=Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        int max = 0;
        Arrays.fill(dp,1); //자기 자신은 무조건 포함하기 때문
        for(int i = 0; i < n; i++){
            for(int j=0; j < i; j++){
                if(line[j]<line[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }

        System.out.println(n-max);
    }
}