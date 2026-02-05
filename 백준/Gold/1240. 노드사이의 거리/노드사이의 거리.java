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
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        for(int i = 0; i <= n; i++){
            nodes.add(new ArrayList<>());
        }
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.get(a).add(new Node(b,c));
            nodes.get(b).add(new Node(a,c));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            visited = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(dfs(a,b)).append("\n");
        }
        System.out.println(sb);

    }
    static int dfs(int cur, int target){
        if(cur == target) return 0; //도착
        visited[cur] = true;

        for(Node node: nodes.get(cur)){
            if(!visited[node.to]){
                int sub = dfs(node.to, target);
                if(sub!=-1) return sub + node.weight;
            }
        }
        return -1;
    }
}