import java.util.*;
import java.io.*;

public class Main{
    static List<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        tree = new List[n+1];
        visited = new boolean[n+1];
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);

    }
    static void dfs(int cur){
        visited[cur] = true;

        for(int i : tree[cur]){
            if(!visited[i]){
                parent[i] = cur;
                dfs(i);
            }
        }
    }
}