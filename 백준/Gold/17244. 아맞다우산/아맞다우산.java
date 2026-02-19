import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static int[][] itemId;
    static boolean[][][] visited;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int r, c, mask, dist;

        public State(int r, int c, int mask, int dist) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //열
        m = Integer.parseInt(st.nextToken()); //행


        int sr=-1, sc = -1;
        int k=0; //물건 개수
        map = new char[m][n];
        itemId = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(itemId[i], -1);

        for(int i = 0; i < m; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S'){
                    sr=i; sc=j;
                }
                if(map[i][j] == 'X'){
                    itemId[i][j] = k++;
                }

            }
        }
        int all = (1<<k)-1; //물건모두 수집되었을때 비트마스크
        visited = new boolean[m][n][1<<k];
        ArrayDeque<State> q = new ArrayDeque<>();

        q.offer(new State(sr, sc, 0, 0));
        visited[sr][sc][0] = true;

        while(!q.isEmpty()){
            State curr = q.poll();

            //종료조건 E를 만나고, 물건을 모두 주웠을때
            if(map[curr.r][curr.c] == 'E' && curr.mask == all){
                System.out.println(curr.dist);
                return;
            }

            for(int i=0; i<4; i++){
                int nr = curr.r + dy[i];
                int nc = curr.c + dx[i];

                if(nr<0 || nc<0 || nr>=m || nc>=n) continue;
                if(map[nr][nc] == '#') continue;

                int bitmask = curr.mask;
                if(map[nr][nc] == 'X'){
                    int m = itemId[nr][nc];
                    bitmask |= 1<<m;
                }

                if(!visited[nr][nc][bitmask]){
                    visited[nr][nc][bitmask] = true;
                    q.offer(new State(nr, nc, bitmask, curr.dist+1));
                }
            }
        }
    }
}