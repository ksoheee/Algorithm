import java.util.*;
import java.io.*;
public class Main {
    static int[] arr;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(1,0);

    }
    public static void dfs(int at,int depth){
        if(depth == M){
            for(int val: arr){
                System.out.print(val+" ");
            }
            System.out.println();
            return;
        }
        for(int i=at; i<=N; i++){
            arr[depth]=i;
            dfs(i+1,depth+1);
        }
    }
}