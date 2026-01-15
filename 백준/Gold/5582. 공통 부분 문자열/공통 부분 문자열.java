import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 10_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        int sLen = s.length();
        int tLen = t.length();
        int max = 0;
        int[][] dp = new int[sLen][tLen];

        for(int i=0; i<sLen; i++){
            for(int j=0; j<tLen; j++){
                if(s.charAt(i) == t.charAt(j)){ 
                    //공통 문자열의 길이가 1일때 
                    if(i == 0 || j== 0) dp[i][j] = 1;
                    else                dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j]=0;
                }
                //최대 길이 갱신
                if(dp[i][j]>max) max = dp[i][j];
            }
        }
        System.out.println(max);
    }

}