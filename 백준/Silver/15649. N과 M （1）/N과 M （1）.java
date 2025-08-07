import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        
        arr=new int[M];
        visit=new boolean[N];
        dfs(N,M,0);
        
    }
    private static void dfs(int N, int M, int depth){
        if(depth==M){
            for(int val: arr){
                System.out.print(val+" ");
            }
            System.out.println();
            return;
        }
        
        
        for(int i=0; i<N; i++){
            if(visit[i]==false){
                visit[i]=true;
                arr[depth]=i+1;
                dfs(N,M,depth+1);
                
                visit[i]=false;
            }
        }
    }
}