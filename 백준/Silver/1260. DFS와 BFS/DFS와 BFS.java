import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int v= Integer.parseInt(st.nextToken());
        
        graph = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num1= Integer.parseInt(st.nextToken());
            int num2= Integer.parseInt(st.nextToken());
            graph[num1][num2]=graph[num2][num1]=1;
        }
        visited = new boolean[n+1];
        DFS(v);
        
        System.out.println();
        
        visited = new boolean[n+1];
        BFS(v);
    }
    public static void DFS(int v){
        visited[v]=true;
        System.out.print(v+" ");
        for(int i=1; i<graph.length; i++){
            if(graph[v][i]==1 && visited[i]==false ){
                DFS(i);
            }
        }
    }
    public static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v]=true;
        System.out.print(v+" ");
        
        while(!queue.isEmpty()){
            int temp=queue.poll();
            for(int i=1; i<graph.length; i++){
                if(graph[temp][i]==1 && visited[i]==false){
                    queue.add(i);
                    visited[i]=true;
                    System.out.print(i+" ");
                }
            }
        }        
    }
}