import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i][0]= Integer.parseInt(st.nextToken());
            arr[i][1]= Integer.parseInt(st.nextToken());
        }
        //정렬
        Arrays.sort(arr, (o1, o2) -> o1[0]-o2[0]);

        int[] dp = new int[n];
        dp[0]=1;
        int max = 0;
        for(int i=1; i<n; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(arr[i][1]>arr[j][1]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
                max = Math.max(max,dp[i]);
            }
        }
        System.out.println(n-max);
    }
}
