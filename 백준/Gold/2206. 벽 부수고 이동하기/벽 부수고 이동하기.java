import java.util.*;
import java.io.*;

class Main{
    static int[][] road;
    static int[][][] dist;
    static boolean[][][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        road = new int[n][m];
        dist = new int[n][m][2];
        visited = new boolean[n][m][2]; //벽을 부쉈는지 안부쉈는지
        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            for(int j=0; j<m; j++){
                road[i][j]=tmp.charAt(j)-'0';
            }
        }
        System.out.println(bfs());
    }
    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.offer(new int[]{0,0,0});
        dist[0][0][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int w = cur[2];

            if(y==n-1 && x==m-1){
                return dist[y][x][w];
            }

            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(nx<0 || ny<0 || ny>=n || nx>=m) continue;

                //벽이고 아직 안부쉈고, 방문하지 않았다면
                if(road[ny][nx]==1 && w==0 && !visited[ny][nx][1]){
                    visited[ny][nx][1] = true;
                    dist[ny][nx][1]=dist[y][x][w]+1;
                    q.offer(new int[]{ny,nx,1});
                }
                //길일 때
                else if(road[ny][nx]==0 && !visited[ny][nx][w]){
                    visited[ny][nx][w] = true;
                    dist[ny][nx][w]=dist[y][x][w]+1;
                    q.offer(new int[]{ny,nx,w});
                }
            }
        }
        return -1;
    }
}