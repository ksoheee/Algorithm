import java.util.*;
import java.io.*;

class Main{
    static String keys;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n,m;
    static int cnt;
    static boolean[][] visited;
    static boolean[] hasKey;
    public static void main(String[] agrs)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char[n+2][m+2];

            //맵 한칸 확장 (j=0, j=n+1 k=0, k=m+1)
            for (int j = 0; j <= n+1; j++) {
                for (int k = 0; k <= m+1; k++) {
                    arr[j][k] = '.';
                }
            }

            for (int j = 1; j <= n; j++) {
                String tmp = br.readLine();
                for (int k = 1; k <= m; k++) {
                    arr[j][k] = tmp.charAt(k-1);
                }
            }
            hasKey = new boolean[26];
            keys = br.readLine();
            if (!keys.equals("0")){
                for(char c : keys.toCharArray()){
                    hasKey[c-'a'] = true;
                }
            }

            sb.append(bfs()).append('\n');
        }
        System.out.println(sb);

    }
    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n+2][m+2];

        visited[0][0] = true;
        q.offer(new int[]{0,0});

        List<int[]>[] door = new ArrayList[26];
        for(int i=0;i<26;i++){
            door[i] = new ArrayList<>();
        }
        cnt = 0;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int py = cur[0];
            int px = cur[1];

            for(int i=0; i<4; i++){
                int ny = py+dx[i];
                int nx = px+dy[i];

                if(ny<0 || ny>=n+2 || nx<0 || nx>=m+2 || arr[ny][nx]=='*' || visited[ny][nx]) continue;
                //문
                if('A'<=arr[ny][nx] && arr[ny][nx] <= 'Z'){
                    if(!hasKey[arr[ny][nx]-'A']){
                        door[arr[ny][nx]-'A'].add(new int[]{ny,nx});
                        continue;
                    }
                }
                //열쇠
                if('a'<=arr[ny][nx] && arr[ny][nx] <= 'z'){
                    if(!hasKey[arr[ny][nx]-'a']){
                        hasKey[arr[ny][nx]-'a'] = true;
                        for(int[] d: door[arr[ny][nx]-'a']){
                            q.offer(d);
                            visited[d[0]][d[1]] = true;
                        }
                    }
                }
                //문서
                if(arr[ny][nx]=='$') cnt++;

                visited[ny][nx] = true;
                q.offer(new int[]{ny,nx});

            }
        }
        return cnt;
    }
}