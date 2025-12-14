import java.io.*;
import java.util.*;

public class Main {

    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] hasKey;
    static List<int[]>[] doors;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            //외부 패딩
            map = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(map[i], '.');
            }

            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = line.charAt(j - 1);
                }
            }

            hasKey = new boolean[26];
            String keyLine = br.readLine();
            if (!keyLine.equals("0")) {
                for (char c : keyLine.toCharArray()) {
                    hasKey[c - 'a'] = true;
                }
            }

            doors = new ArrayList[26];
            for (int i = 0; i < 26; i++) doors[i] = new ArrayList<>();

            visited = new boolean[h + 2][w + 2];

            sb.append(bfs()).append('\n');
        }

        System.out.print(sb);
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        int documents = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || nx < 0 || ny >= h + 2 || nx >= w + 2) continue;
                if (visited[ny][nx] || map[ny][nx] == '*') continue;

                char c = map[ny][nx];

                // 문
                if ('A' <= c && c <= 'Z') {
                    int idx = c - 'A';
                    if (!hasKey[idx]) {
                        doors[idx].add(new int[]{ny, nx});
                        continue;
                    }
                }

                // 열쇠
                if ('a' <= c && c <= 'z') {
                    int idx = c - 'a';
                    if (!hasKey[idx]) {
                        hasKey[idx] = true;
                        for (int[] door : doors[idx]) {
                            q.offer(door);
                        }
                        doors[idx].clear();
                    }
                }

                // 문서
                if (c == '$') {
                    documents++;
                }

                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
        }

        return documents;
    }
}
