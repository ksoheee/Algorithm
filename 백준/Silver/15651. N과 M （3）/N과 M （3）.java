import java.util.*;
import java.io.*;
public class Main {
    static int[] arr;
    static int N;
    static int M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        sb = new StringBuilder();
        dfs(0);
        System.out.print(sb);

    }
    public static void dfs(int depth){
        if(depth == M){
            for(int val: arr){
               sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){

            arr[depth] = i+1;
            dfs(depth+1);
        }
    }
}