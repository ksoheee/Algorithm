import java.util.*;
import java.io.*;
public class Main {
    static char[][] pictureN, pictureRG;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        pictureN = new char[N][N];
        pictureRG = new char[N][N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                pictureN[i][j]= str.charAt(j);
                pictureRG[i][j]= str.charAt(j) == 'R'? 'G': str.charAt(j);
            }
        }

        visited = new boolean[N][N];
        int cutN = countAreas(pictureN);
        visited = new boolean[N][N];
        int cutRG = countAreas(pictureRG);

        System.out.println(cutN+" "+cutRG);
    }
    static int countAreas(char[][] picture){
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(i,j,picture);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void bfs(int a,int b, char[][] picture){
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
}
