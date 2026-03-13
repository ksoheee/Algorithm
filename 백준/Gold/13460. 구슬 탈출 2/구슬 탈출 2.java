import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, depth;

        State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static class MoveResult {
        int x, y, dist;
        boolean inHole;

        MoveResult(int x, int y, int dist, boolean inHole) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.inHole = inHole;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.depth >= 10) continue;

            for (int dir = 0; dir < 4; dir++) {
                MoveResult red = move(cur.rx, cur.ry, dir);
                MoveResult blue = move(cur.bx, cur.by, dir);

                // 파란 구슬이 구멍에 빠지면 실패
                if (blue.inHole) continue;

                // 빨간 구슬만 구멍에 빠지면 성공
                if (red.inHole) return cur.depth + 1;

                int nrx = red.x;
                int nry = red.y;
                int nbx = blue.x;
                int nby = blue.y;

                // 둘이 같은 칸에 멈춘 경우
                if (nrx == nbx && nry == nby) {
                    if (red.dist > blue.dist) {
                        nrx -= dx[dir];
                        nry -= dy[dir];
                    } else {
                        nbx -= dx[dir];
                        nby -= dy[dir];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.offer(new State(nrx, nry, nbx, nby, cur.depth + 1));
                }
            }
        }

        return -1;
    }

    static MoveResult move(int x, int y, int dir) {
        int nx = x;
        int ny = y;
        int dist = 0;

        while (board[nx + dx[dir]][ny + dy[dir]] != '#') {
            nx += dx[dir];
            ny += dy[dir];
            dist++;

            if (board[nx][ny] == 'O') {
                return new MoveResult(nx, ny, dist, true);
            }
        }

        return new MoveResult(nx, ny, dist, false);
    }
}