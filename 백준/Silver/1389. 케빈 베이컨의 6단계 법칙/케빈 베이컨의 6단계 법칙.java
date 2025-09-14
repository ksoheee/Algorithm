import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Integer>[] people;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        people = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            people[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int n1 =  Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            people[n1].add(n2);
            people[n2].add(n1);
        }
        int result =Integer.MAX_VALUE;
        int answer = 0;
        for(int i=1; i<=N; i++){
            int value = bfs(i);
            if(result>value){
                result = value;
                answer = i;
            }
        }
        System.out.print(answer);
    }
    static int bfs(int num) {
        visited = new boolean[N + 1];
        int[] dist = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);

        while (!q.isEmpty()) {
            int n = q.poll();
            for (int next: people[n]) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    dist[next] = dist[n]+1;
                }
            }
        }
        int sum=0;
        for(int i=1; i<=N; i++){
            sum += dist[i];
        }
        return sum;
    }
}
