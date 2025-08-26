import java.io.IOException;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;
public class Main {
    static boolean[] visit;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        arr = new int[M];
        dfs(N,M,0);
    }
    public static void dfs(int N, int M, int depth){
        if(depth==M){
            for(int v: arr){
                System.out.print(v+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=N; i++){
            if(!visit[i]){ //방문하지 않았다면
                visit[i]=true;
                arr[depth]=i;
                dfs(N,M,depth+1);
                visit[i]=false;
            }
        }
    }
}