import java.io.*;
import java.util.*;

public class Main {
	
	static int max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Case = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
		int[] T = new int[Case];//소요 기간
		int[] P = new int[Case];//금액
        
		for(int i=0;i<Case;i++) {
            st = new StringTokenizer(br.readLine()," ");
			T[i]=Integer.parseInt(st.nextToken());	
			P[i]=Integer.parseInt(st.nextToken());	
		}
		
		int[] dp = new int[Case+1];
		
		for(int i=0;i<Case;i++) {
			 if(i+T[i]<=Case) {	//범위에 벗어나지 않는다면 
				 dp[i+T[i]]=Math.max(dp[i+T[i]],dp[i]+P[i]);	
			 }
			 dp[i+1]=Math.max(dp[i+1],dp[i]);	
			 
		}
		System.out.println(dp[Case]);	
	}
}