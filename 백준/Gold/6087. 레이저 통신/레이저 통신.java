import java.io.*;
import java.util.*;

public class Main {
   static char[][] map;
   static List<int[]> list;
   static int[] dx = {-1, 1, 0, 0};
   static int[] dy = {0, 0, -1, 1};
   static final int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String ss = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = ss.charAt(j);
                if(map[i][j] == 'C'){
                    list.add(new int[] {i, j});
                }
            }
        }

        //시작점과 끝점
        int sr = list.get(0)[0]; int sc = list.get(0)[1];
        int er = list.get(1)[0]; int ec = list.get(1)[1];

        //(r,c)에 dir 방향으로 도착했을 때 필요한 최소 거울 수 (방향 0~3)
        int[][][] dist =  new int[N][M][4];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                Arrays.fill(dist[i][j], INF);


        //시작은 모든 방향으로 발사할수 있음
        dist[sr][sc][0] = 0;
        dist[sr][sc][1] = 0;
        dist[sr][sc][2] = 0;
        dist[sr][sc][3] = 0;

        //큐가 아니라 덱을 사용해서 간선 비용이 더 적은 방향을 먼저 탐색하도록
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {sr, sc, 0});
        dq.offer(new int[] {sr, sc, 1});
        dq.offer(new int[] {sr, sc, 2});
        dq.offer(new int[] {sr, sc, 3});

        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cdir = cur[2];
            int curCost = dist[cr][cc][cdir]; //현재 위치 거울수

            for(int i = 0; i < 4; i++){
                int ny = cr + dy[i];
                int nx = cc + dx[i];

                int cost; // 탐색한 위치에 i 방향으로 도착하는 최소 거울 수 후보
                if(ny<0 || ny>=N || nx<0 || nx>=M || map[ny][nx] == '*') continue;

                //현재 방향과 탐색한 방향이 같으면 현재위치 거울수, 다르면 +1
                if(cdir == i) cost = curCost;
                else cost = curCost + 1;

                //새로 계산한 후보 cost가 기존 dist 보다 작으면
                if(dist[ny][nx][i]>cost){
                    dist[ny][nx][i] = cost;
                    //가중치에 따라 앞 뒤에 삽입
                    if(i == cdir) dq.addFirst(new int[] {ny, nx, i});
                    else dq.addLast(new int[] {ny, nx, i});
                }
            }
        }
        int ans = INF;
        for(int i=0; i<4; i++) ans = Math.min(ans, dist[er][ec][i]);
        System.out.println(ans);

    }
}
