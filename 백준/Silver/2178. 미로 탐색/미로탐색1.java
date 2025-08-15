import java.io.*;
import java.util.*;
public class Main{
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                graph[i][j]=temp.charAt(j)-'0';
            }
        }
        visited = new boolean[N][M];
        BFS(0,0);
        System.out.println(graph[N-1][M-1]);


    }
    public static void BFS(int n, int m){
        visited[n][m]=true;
        Queue<pos> q = new LinkedList<>();
        //자바에서는 배열 생성 시 반드시 길이 또는 초기화 값을 지정해야 함
        q.add(new pos(n,m)); //길이가 2인 int배열을 생성하면서 동시에 값을 초기화

        while(!q.isEmpty()){
            pos p = q.poll();
            int nowX = p.x; //x좌표
            int nowY = p.y; //y좌표

            for(int i=0; i<4; i++){ //상하좌우 확인
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX<0 || nextY<0 || nextX>=N || nextY>=M) continue;
                if(visited[nextX][nextY] || graph[nextX][nextY]==0) continue;
                q.add(new pos(nextX,nextY));
                graph[nextX][nextY]=graph[nowX][nowY]+1;
                visited[nextX][nextY]=true;
            }
        }
    }
}
class pos{
    int x;
    int y;
    pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
