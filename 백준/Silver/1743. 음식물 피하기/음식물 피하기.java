import java.util.*;
import java.io.*;
public class Main {
    static int[][] food;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int cnt,N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        food = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            food[x][y]=1;
        }

        cnt=1;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++) {
                if (food[i][j] == 1) {
                    cnt = Math.max(dfs(i, j), cnt);
                }
            }
        }
        System.out.println(cnt);
    }
    static int dfs(int a, int b){
        visited[a][b]=true;
        int size = 1;

        for(int i=0; i<4; i++){
            int nextX = a+dx[i];
            int nextY = b+dy[i];

            if(nextX<0 || nextY<0|| nextX>N || nextY>M) continue;
            if(food[nextX][nextY]==1 && !visited[nextX][nextY]){
                size +=dfs(nextX,nextY);
            }
        }
        return size;
    }
}
