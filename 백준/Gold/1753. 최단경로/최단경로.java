import java.util.*;
import java.io.*;

class Main{
    static List<Edge>[] graph;
    static final int INF = Integer.MAX_VALUE;
    static int V,E,K;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        for(int i = 0; i <= V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine()," ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int v3 = Integer.parseInt(st.nextToken());
            graph[v1].add(new Edge(v2,v3));
        }
        int[] answer = dijkstra(K, graph);
        for(int i=1; i<=V; i++){
            if (answer[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(answer[i]);
            }
        }
    }
    static int[] dijkstra(int start, List<Edge>[] graph){
        boolean[] visited = new boolean[V+1];
        int[] dist = new int[V+1];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur =  pq.poll();
            int v = cur.v;

            if(visited[v]) continue;
            visited[v] = true;

            for(Edge e : graph[v]){
                int to = e.to;
                int weight = e.weight;
                //시작점에서 to까지의 최소 거리보다  v를 거쳐서 가는 방법이 더 짧다면 갱신
                if(!visited[to] && dist[to]>dist[v]+weight){
                    dist[to] = dist[v]+weight;
                    pq.offer(new Node(to,dist[to]));
                }
            }
        }
        return dist;
    }
    //그래프
    static class Edge{
        int to;  //도착 정점
        int weight; //가중치

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    //탐색
    //시작 정점에서 v까지의 알려진 거리 정보
    static class Node implements Comparable<Node> {
        int v;
        int dist;
        Node(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }
}
