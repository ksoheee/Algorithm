import java.util.*;
import java.io.*;

class Main{
    static int[][] road;
    static int n;

    static int size = 2;    //상어크기
    static int time;        //걸린시간
    static int eatCnt;      //먹은 먹이수

    //탐색 방향 상,좌,우,하
    static int[] dx = {0,-1,1,0};
    static int[] dy = {-1,0,0,1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        road = new int[n][n];
        int sy = 0; int sx = 0; //상어좌표
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                road[i][j] = Integer.parseInt(st.nextToken());
                if(road[i][j] == 9){
                    sy = i; sx = j;
                    road[i][j] = 0;
                }
            }
        }
        //먹을 수 있는 물고기 모두 탐색
        while(true){
            int[] f = bfs(sy,sx);
            if(f==null) break;

            sy = f[1];
            sx = f[2];
            time += f[0];
            eatCnt++;
            road[sy][sx] = 0; //물고기 먹음

            if(eatCnt==size){
                size++;
                eatCnt = 0;
            }
        }
        System.out.println(time);

    }
    //가장 가까운 물고기 1개 탐색
    public static int[] bfs(int y, int x){
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x,0});

        //먹은 물고기들(거리,행,열)
        List<int[]> yum = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            int dist =  cur[2];

            if(minDist < dist) break;

            for(int i = 0; i < 4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(ny<0 || nx<0 || ny>=n ||nx>=n) continue;
                if(visited[ny][nx] || road[ny][nx]>size) continue;

                q.offer(new int[]{ny,nx,dist+1});
                visited[ny][nx] = true;
                //먹을 수 있는 물고기
                if(road[ny][nx]>0 && road[ny][nx]<size){
                    yum.add(new int[]{dist+1,ny,nx});
                    minDist = dist+1;
                }
            }
        }

        if(yum.isEmpty()) return null;

        //거리, 행, 열 순
        Collections.sort(yum, (o1,o2)->{
            if(o1[0]!=o2[0]) return o1[0]-o2[0];
            if(o1[1]!=o2[1]) return o1[1]-o2[1];
            return o1[2]-o2[2];
        });
        return yum.get(0);
    }

}