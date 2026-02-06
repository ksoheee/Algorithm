import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static class Node{
        int to;
        int weight;
        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static List<List<Node>> nodes = new ArrayList<>();
    static int maxDist;
    static int farNode;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n==1){
            System.out.println(0);
            return;
        }

        for(int i = 0; i <= n; i++){
            nodes.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.get(a).add(new Node(b, c));
            nodes.get(b).add(new Node(a, c));
        }


        //1에서 가장 먼 노드 찾기
        visited = new boolean[n+1];
        maxDist = -1;
        farNode = 1; //유효한 노드로 초기화 하기 위해
        dfs(1,0);

        //farNode에서 가장 먼 노드 찾기
        visited = new boolean[n+1];
        maxDist = -1;
        dfs(farNode,0);

        System.out.println(maxDist);

    }
    static void dfs(int cur, int dist){
        visited[cur] = true;

        if(dist> maxDist){
            maxDist = dist;
            farNode = cur;
        }

        for(Node node: nodes.get(cur)){
            if(!visited[node.to]){
                dfs(node.to, dist+node.weight);
            }
        }
    }

}