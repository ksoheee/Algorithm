import java.util.*;
import java.io.*;
public class Main {
    static boolean[] visited;
    static int[][] arr;
    static int cnt;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b]=1;
            arr[b][a]=1;
        }
        bfs(1);
        System.out.println(cnt);
    }
    static void bfs(int s){
        visited[s]=true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        
        while(!q.isEmpty()){
            int t = q.poll();
            for(int i=1; i<=N; i++){
                if(!visited[i] && arr[t][i]==1){
                    q.offer(i);
                    visited[i]=true;
                    cnt++;
                }
            }
        }
    }
}
