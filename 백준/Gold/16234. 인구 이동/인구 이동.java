import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] space;
    static boolean[][] visited;
    static int N,L,R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //입력
        space = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //연합이 안나올때까지
        int day = 0;
        while(true){
            visited  = new boolean[N][N];
            boolean moved = false;
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        if(bfs(i,j)){
                            moved = true;
                        }
                    }
                }
            }

            if(!moved) break;
            day++;
        }
        System.out.println(day);

    }
    static boolean bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>(); //연합

        q.offer(new int[]{r,c});
        visited[r][c] = true;
        union.add(new int[]{r,c});

        int sum = space[r][c];
        while(!q.isEmpty()){
            int[] cur =  q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = cr + dy[i];
                int nc = cc + dx[i];

                if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if(visited[nr][nc]) continue;
                int diff = Math.abs(space[cr][cc] - space[nr][nc]);
                if(L<= diff && diff<= R) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                    union.add(new int[]{nr, nc});
                    sum += space[nr][nc];
                }
            }
        }
        if(union.size()<=1) return false;
        int average = sum/union.size();
        for(int[] u : union){
            space[u[0]][u[1]] = average;
        }
        return true;
    }
}
