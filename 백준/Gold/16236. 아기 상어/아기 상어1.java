import java.io.*;
import java.util.*;

public class Main {
    //탐색 방향 위->왼
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,-1,0,1};
    static int[][] space;
    static int n;
    static int shark;
    static int eatTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //입력
        StringTokenizer st;
        space = new int[n][n];
        int fr = 0, fc = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < n; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if(space[i][j] == 9){
                    fr = i; fc = j;
                    space[i][j] = 0;
                }
            }
        }

        //처음 상어 크기
        shark = 2;
        int fish = 0; //현재 먹은 물고기 수
        //물고기 못먹을 때까지 진행
        while(true){
            //System.out.println("진행 횟수: "+fi);
            int[]eat = eatFish(fr, fc);
            //물고기 못먹었다면
            if(eat==null){
                System.out.println(eatTime);
                break;
            }

            //상어 위치 갱신
            fr = eat[0];
            fc = eat[1];
            eatTime += eat[2];
            fish++;

            //물고기 먹은 곳 빈칸으로 변경
            space[fr][fc] = 0;

            //물고기 먹은 수 == 상어 크기 -> 상어 성장
            if(fish == shark){
                fish = 0;
                shark++;
            }
        }

    }
    //물고기 한개 먹을 때마다 탐색
    //먹은 물고기 좌표 반환, 걸린시간
    static int[] eatFish(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new int[]{r,c,0});
        visited[r][c] = true;

        List<int[]> eat = new ArrayList<>();
        //Arrays.fill(eat, Integer.MAX_VALUE);

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];
            int time = curr[2];


            for(int i = 0; i < 4; i++){
                int nr = cr + dy[i];
                int nc = cc + dx[i];

                if(nr <0 || nc < 0 || nr >=n || nc >=n) continue;
                if(visited[nr][nc] || space[nr][nc]>shark) continue;
                if(space[nr][nc] != 0 && space[nr][nc]<shark){
                    eat.add(new int[]{nr, nc, time+1});
                }
                visited[nr][nc] = true;
                q.offer(new int[]{nr,nc,time+1});
            }
        }
        //물고기를 못먹었다면
        if(eat.isEmpty()) return null;

        Collections.sort(eat, (o1, o2)->{
            if(o1[2]!= o2[2]) return o1[2]-o2[2];
            if(o1[0]!= o2[0]) return o1[0]-o2[0];
            return o1[1]-o2[1];
        });
        return eat.get(0);
    }
}
