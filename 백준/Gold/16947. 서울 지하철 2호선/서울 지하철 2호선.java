import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> nodes = new ArrayList<>();
    static int[] dist;          //순환선 까지의 거리
    static int[] degree;        //각 노드 차수
    static boolean[] removed;   //잘려간 노드 표시
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++){
            nodes.add(new ArrayList<>());
        }
        dist = new int[n+1];
        degree = new int[n+1];
        removed = new boolean[n+1];

        //거리 전부 -1로 초기화
        for(int i = 0; i <= n; i++) Arrays.fill(dist, -1);

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
            //간선을 입력받았으니 ++
            degree[a]++; degree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        //간선이 1인 노드 전부 넣기
        for(int i = 1; i <= n; i++){
            if(degree[i] == 1){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            removed[cur] = true;

            for(int node : nodes.get(cur)){
                degree[node]--;
                if(degree[node] == 1){
                    q.offer(node);
                }
            }
        }

        //removed[]=false인 노드들이 순환선
        q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(!removed[i]){
                dist[i] = 0;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int node : nodes.get(cur)){
                if(dist[node] == -1){
                    dist[node] = dist[cur] + 1;
                    q.offer(node);
                }
            }
        }

        for(int i=1; i <= n; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();

    }
}