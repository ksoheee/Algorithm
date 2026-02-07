import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            list[i]= new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            list[X].add(Y);
            list[Y].add(X);
        }

        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);

    }
    static void dfs(int cur){

        for(int n : list[cur]){
            if(!visited[n]){
                visited[n] = true;
                dfs(n);
            }
        }

    }


}