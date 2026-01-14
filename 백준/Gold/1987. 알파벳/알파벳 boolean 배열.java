import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] board;
    static int N,M;
    static int max;
    static boolean[] alphabet = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //입력
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        int idx =board[0][0] - 'A';
        alphabet[idx] = true;

        dfs(1,0,0);
        System.out.println(max);
    }
    static void dfs(int dep, int r, int c){
        max = Math.max(max, dep);

        for(int i = 0; i < 4; i++){
            int nr = r + dy[i];
            int nc = c + dx[i];

            if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
            int idx = board[nr][nc]-'A';
            if(alphabet[idx]) continue;
            alphabet[idx] = true;
            dfs(dep+1, nr, nc);
            alphabet[idx] = false;
        }
    }
}
