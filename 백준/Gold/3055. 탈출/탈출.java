import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static char[][] forest;
    static int[][] waterTime;
    static final int INF  = 1_000_000;
    static Queue<int[]> water;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int sr=0, sc=0; int dr=0, dc=0;
        forest = new char[n][m];
        waterTime = new int[n][m];
        water = new LinkedList<>();
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                forest[i][j] = line.charAt(j);
                waterTime[i][j] = INF;
                if(forest[i][j] == 'S'){
                    sr=i; sc=j;
                }
                if(forest[i][j] == 'D'){
                    dr=i; dc=j;
                }
                if(forest[i][j] == '*'){
                    water.offer(new int[]{i,j});
                    waterTime[i][j] = 0;
                }
            }
        }

        fullWater();
        int answer = move(sr,sc,dr,dc);

        if(answer ==INF)        System.out.println("KAKTUS");
        else                    System.out.println(answer);

    }
    static int move(int sr, int sc, int dr, int dc){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            int t = cur[2];

            if (cr == dr && cc == dc) {
                return t;
            }

            for(int i = 0; i < 4; i++){
                int nr = cr + dy[i];
                int nc = cc + dx[i];

                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                if(visited[nr][nc] || forest[nr][nc]=='X') continue;
                if(forest[nr][nc]!='D' && t+1>=waterTime[nr][nc]) continue;
                queue.offer(new int[]{nr, nc, t+1});
                visited[nr][nc] = true;
            }

        }
        return INF;
    }
    static void fullWater(){
        while(!water.isEmpty()){
            int[] cur = water.poll();
            int cr = cur[0];
            int cc = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = cr + dy[i];
                int nc = cc + dx[i];

                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                if(forest[nr][nc]=='D' || forest[nr][nc]=='X') continue;
                if(waterTime[nr][nc] != INF) continue;

                waterTime[nr][nc] = waterTime[cr][cc] + 1;
                water.offer(new int[]{nr, nc});
            }
        }
    }

}