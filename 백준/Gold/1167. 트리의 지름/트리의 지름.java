import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int t, w;
        public Node(int t, int w){
            this.t = t;
            this.w = w;
        }
    }

    static List<Node>[] nodes;
    static boolean[] visited;
    static int farNode;
    static int maxNum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        nodes = new ArrayList[n+1];

        for(int i = 1; i <= n; i++) nodes[i] = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());

            while(true){
                int connectionNum = Integer.parseInt(st.nextToken());
                if(connectionNum == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                nodes[nodeNum].add(new Node(connectionNum, weight));

            }
        }
        //한개의 노선 골라서 그 노선에서 가장 먼 노선 찾기
        farNode = 1;
        maxNum = -1;
        visited = new boolean[n+1];
        dfs(1,0);



        //그 노선에서 가장 먼 노선 찾기
        maxNum = -1;
        visited = new boolean[n+1];
        dfs(farNode,0);

        System.out.println(maxNum);


    }
    static void dfs(int cur, int dist){
        visited[cur] = true;

        if(maxNum <dist){
            maxNum = dist;
            farNode = cur;
        }

        for(Node node: nodes[cur]){
            if(!visited[node.t]){
                dfs(node.t, dist+node.w);
            }
        }
    }


}