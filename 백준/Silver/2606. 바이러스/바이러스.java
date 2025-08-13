import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static int[][] graph;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int total = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st; 
        graph = new int[total+1][total+1];
        
        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y]= graph[y][x]=1;
        }
        visited = new boolean[total+1];
        DFS(1);
        System.out.println(cnt);
        
        
    }
    public static void DFS(int v){
        visited[v]=true;
        for(int i=0; i<graph.length; i++){
            if(graph[v][i]==1 && visited[i]==false){
                cnt++;
                DFS(i);
            }
        }
        
    }
}