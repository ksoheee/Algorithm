import java.util.*;
import java.io.*;
public class Main {
    static char[][] picture;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        picture = new char[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                picture[i][j]= str.charAt(j);
            }
        }
        int cnt=0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        int cntrg=0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfsrg(i,j);
                    cntrg++;
                }
            }
        }
        System.out.println(cnt+" "+cntrg);
    }
    static void bfs(int a,int b){
        Queue<int[]> q = new LinkedList<>();
        visited[a][b] = true;
        q.offer(new int[]{a,b});

        while(!q.isEmpty()){
            int[] pre=q.poll();
            int py = pre[0];
            int px = pre[1];

            char cur = picture[py][px];
            for(int i=0; i<4; i++){
                int ny = py + dy[i];
                int nx = px + dx[i];

                if(ny<0||nx<0||ny>=N||nx>=N) continue;
                if(picture[ny][nx]!=cur) continue;
                if(visited[ny][nx])continue;
                visited[ny][nx]=true;
                q.offer(new int[]{ny,nx});
            }
        }
    }
    static void bfsrg(int a,int b){
        Queue<int[]> q = new LinkedList<>();
        visited[a][b] = true;
        q.offer(new int[]{a,b});

        while(!q.isEmpty()){
            int[] pre=q.poll();
            int py = pre[0];
            int px = pre[1];

            char cur = picture[py][px];

            for(int i=0; i<4; i++){
                int ny = py + dy[i];
                int nx = px + dx[i];

                if(ny<0||nx<0||ny>=N||nx>=N) continue;
                if(cur == 'R' || cur == 'G'){
                    if(picture[ny][nx]=='B') continue;
                }else{
                    if(picture[ny][nx]!='B') continue;
                }
                if(visited[ny][nx])continue;
                visited[ny][nx]=true;
                q.offer(new int[]{ny,nx});
            }
        }
    }
}