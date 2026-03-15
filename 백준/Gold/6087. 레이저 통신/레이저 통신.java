import java.io.*;
import java.util.*;

public class Main {
    
    static char[][] map;
    static List<int[]> list;
    static final int INF = 1_000_000_000;
    static int[][][] mirrorNum;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'C'){
                    list.add(new int[]{i, j});
                }
            }
        }

        int startR = list.get(0)[0], startC = list.get(0)[1];
        int endR = list.get(1)[0], endC = list.get(1)[1];

        mirrorNum = new int[n][m][4]; //상하좌우 4방향
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                Arrays.fill(mirrorNum[i][j],INF);
            }
        }

        mirrorNum[startR][startC][0] = 0;
        mirrorNum[startR][startC][1] = 0;
        mirrorNum[startR][startC][2] = 0;
        mirrorNum[startR][startC][3] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startR, startC, 0});
        q.offer(new int[]{startR, startC, 1});
        q.offer(new int[]{startR, startC, 2});
        q.offer(new int[]{startR, startC, 3});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            int curDist =  cur[2];

            int curMirrorN = mirrorNum[curR][curC][curDist];

            for(int i = 0; i < 4; i++){
                int nextR = curR + dy[i];
                int nextC = curC + dx[i];

                int mirrorN = 0;
                if(nextR<0 || nextR >= n || nextC<0 || nextC >= m || map[nextR][nextC] == '*') continue;

                if(i == curDist)    mirrorN = curMirrorN;
                else                mirrorN = curMirrorN + 1;

                if(mirrorN < mirrorNum[nextR][nextC][i]){
                    mirrorNum[nextR][nextC][i] = mirrorN;

                    if(i == curDist)    q.addFirst(new int[]{nextR, nextC, i});
                    else                q.addLast(new int[]{nextR, nextC, i});
                }
            }
        }

        int min = INF;
        for(int i=0; i<4; i++) min = Math.min(mirrorNum[endR][endC][i], min);
        System.out.println(min);
    }
}
