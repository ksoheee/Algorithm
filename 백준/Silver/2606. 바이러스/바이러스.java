
import java.io.*;
import java.util.*;

class Main{
    static List<Integer>[] list;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i]= new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        visited = new boolean[n+1];
        bfs(1);
        System.out.println(cnt);
    }
    public static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        while(!q.isEmpty()){
            int t = q.poll();

            for(int i=0; i<list[t].size(); i++){
                if(!visited[list[t].get(i)]){
                    visited[list[t].get(i)] = true;
                    q.offer(list[t].get(i));
                    cnt++;
                }
            }
        }
    }
}