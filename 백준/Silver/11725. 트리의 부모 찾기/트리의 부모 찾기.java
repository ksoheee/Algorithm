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
        bfs(1);
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }
    static void bfs(int s){
        visited[s] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);

        while(!q.isEmpty()){
            int cur = q.poll();
                for (int i : tree.get(cur)) {
                    if (!visited[i]) {
                        q.offer(i);
                        parent[i] = cur;
                        visited[i] = true;
                    }
                }
            }
        }
}