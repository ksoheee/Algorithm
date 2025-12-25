import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node>[] road = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            road[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            road[A].add(new Node(B,C));
            road[B].add(new Node(A,C));
        }
        //우선순위 큐를 이용해서 거리가 가까운 순으로 먼저 탐색되도록
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.cost - b.cost);
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Node(1,0));
        dist[1] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost>dist[cur.to]) continue;

            //인접한 노드 모두 탐색
            for(Node n : road[cur.to]){
                int newCost = n.cost + cur.cost;
                if(dist[n.to]>newCost){
                    dist[n.to] = newCost;
                    pq.offer(new Node(n.to,newCost));
                }
            }
        }
        System.out.println(dist[N]);
    }
    static class Node{
        int to;
        int cost;
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}