import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] board;
    static boolean[][] visited;
    static int N,M;
    static Set<Character> set;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //입력
        board = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        set = new HashSet<>();
        set.add(board[0][0]);
        dfs(1,0,0);
        System.out.println(max);
    }
    static void dfs(int dep, int r, int c){
        max = Math.max(max, dep);

        for(int i = 0; i < 4; i++){
            int nr = r + dy[i];
            int nc = c + dx[i];

            if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
            if(set.contains(board[nr][nc])) continue;
            set.add(board[nr][nc]);
            dfs(dep+1, nr, nc);
            set.remove(board[nr][nc]);
        }
    }
}