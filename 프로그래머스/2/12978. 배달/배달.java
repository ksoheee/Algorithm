import java.util.*;
class Solution {
    List<Edge>[] graph;
    final int INF = Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i]= new ArrayList<>();
        }
        for(int i=0; i<road.length; i++){
            graph[road[i][0]].add(new Edge(road[i][1],road[i][2]));
            graph[road[i][1]].add(new Edge(road[i][0],road[i][2]));
        }
        
        int[] result = dijkstra(1, N, K, graph);
        for(int i=1; i<=N; i++){
            if(result[i]<=K) answer++;
        }
        
        return answer;
    }
    public int[] dijkstra(int start, int N, int K, List<Edge>[] graph){
        int[] dist = new int[N+1];
        
        Arrays.fill(dist,INF);
        dist[start]=0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
       
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int u = cur.v;
            
            if(cur.dist != dist[cur.v]) continue;
            
            for(Edge e : graph[u]){
                int to = e.to;
                int w = e.weight;
                
                if(dist[to]>dist[u]+w){
                    dist[to]=dist[u]+w;
                    pq.offer(new Node(to,dist[to]));
                }    
            }
        }
        return dist;
    }
    class Node implements Comparable<Node>{
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
    class Edge{
        int to;
        int weight; //가중치
        Edge(int to, int weight){
            this.to = to;
            this.weight= weight;
        }
    }
}