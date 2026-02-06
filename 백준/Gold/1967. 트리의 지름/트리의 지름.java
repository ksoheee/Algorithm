import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int to;
        int weight;
        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static List<List<Node>> nodes = new ArrayList<>();
    static boolean[] visited;
    static int max;
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
        visited = new boolean[n+1];
        dfs(1);
        System.out.println(max);

    }
    static int dfs(int cur){
        visited[cur] = true;
        int top1=0; int top2=0;

        for(Node node : nodes.get(cur)){
            if(!visited[node.to]){
                int childDist = dfs(node.to)+node.weight;

                if(childDist>top1){
                    top2 = top1;
                    top1 = childDist;
                }else if(childDist>top2){
                    top2 = childDist;
                }
            }
        }
        //현재 노드에서의 가장 긴 경로 2개가 max인지 확인
        max = Math.max(top1+top2, max);

        return top1;
    }
}