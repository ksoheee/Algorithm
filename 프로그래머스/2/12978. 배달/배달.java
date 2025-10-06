import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        //인접 리스트
        List<List<Node>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        //양방향 간선 저장
        for(int[] r: road){
            int a = r[0]; int b = r[1]; int c = r[2];
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        //거리배열
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1]=0; //1번 마을은 거리 0
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        pq.offer(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.cost>dist[cur.to]) continue;
            
            for(Node next : graph.get(cur.to)){
                int newCost = cur.cost+ next.cost;
                if(newCost<dist[next.to]){
                    dist[next.to]= newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
        
        int answer=0;
        for(int i=1; i<=N; i++){
            if(dist[i]<=K){
                answer++;
            }
        }
        return answer;
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