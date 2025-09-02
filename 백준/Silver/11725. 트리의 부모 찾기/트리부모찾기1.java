import java.util.*;
import java.io.*;
public class Main {
    static boolean[] visited;
    static int[] parent;
    static List<List<Integer>> tree = new ArrayList<>();
    static int cnt;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());    //각 노드마다 빈 리스트 준비
        }
        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        dfs(1);
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }
    static void dfs(int s){
        visited[s] = true;

        for (int i : tree.get(s)) {
            if (!visited[i]) {
                parent[i] = s;
                dfs(i);
            }
        }
    }
}
