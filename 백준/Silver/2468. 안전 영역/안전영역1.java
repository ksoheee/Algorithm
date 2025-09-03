import java.util.*;
import java.io.*;
public class Main {
    static int[][] area;
    static int areaMax;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        area = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                areaMax = Math.max(areaMax, area[i][j]);
            }
        }
        int cnt = 0;
        for (int i = 0; i <= areaMax; i++) {
            visited = new boolean[N][N];
            int grop = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (area[j][k] > i && !visited[j][k]) {
                        bfs(j, k, i);
                        grop++;
                    }
                }
            }
            cnt = Math.max(cnt, grop);
        }
        System.out.println(cnt);
    }
    static void bfs ( int a, int b, int areaN){
        visited[a][b] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a,b});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (visited[nextX][nextY]) continue;
                if (area[nextX][nextY] <= areaN) continue;
                visited[nextX][nextY] = true;
                q.offer(new int[]{nextX, nextY});
            }
        }

    }
}
