import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] board;
    static int N,M;
    static int max;
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
        int mask = 1<<(board[0][0] - 'A');
        dfs(1,mask,0,0);
        System.out.println(max);
    }
    static void dfs(int dep, int mask, int r, int c){
        max = Math.max(max, dep);

        for(int i = 0; i < 4; i++){
            int nr = r + dy[i];
            int nc = c + dx[i];

            if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
            int idx = board[nr][nc]-'A';
            //이미 사용한 알파벳인지 확인
            if((mask & (1<<idx)) != 0) continue;
            dfs(dep+1,mask | (1<<idx),nr,nc);
        }
    }
}
