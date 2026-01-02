import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int from;
        int to;
        long weight;
        Node(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes.add(new Node(from, to, weight));
        }

        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1]=0;

        for(int i = 1; i <= N-1; i++){
            for(int j=0; j<nodes.size(); j++){
                Node node = nodes.get(j);
                if(dist[node.from] != INF && dist[node.to]>dist[node.from]+ node.weight){
                    dist[node.to] = dist[node.from]+ node.weight;
                }
            }
        }
        boolean possible = true;
        for(int j = 0; j < nodes.size(); j++){
            Node node = nodes.get(j);
            if(dist[node.from] != INF && dist[node.to]>dist[node.from]+ node.weight){
                possible = false;
                break;
            }
        }

        if(!possible){
            System.out.println(-1);
            return;
        }

        for(int i=2; i<dist.length; i++){
            if(dist[i] == INF) System.out.println(-1);
            else System.out.println(dist[i]);
        }

    }
}