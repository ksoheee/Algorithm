import java.util.*;
import java.io.*;

class Main{
    //상우하좌
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //행
        int m = Integer.parseInt(st.nextToken()); //열

        st = new StringTokenizer(br.readLine());
        int robotR = Integer.parseInt(st.nextToken());
        int robotC = Integer.parseInt(st.nextToken());
        int robotD = Integer.parseInt(st.nextToken());

        //0: 청소안함 1: 벽 2: 청소함
        int[][] room = new int[n][m];
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //햔제 칸에서 상하좌우에 빈칸 있으면 90도 회전하고 빈칸일때 앞으로 전진
        int cnt = 0;
        while(true){
            //현재칸 청소
            if(room[robotR][robotC] == 0){
               room[robotR][robotC] = 2;
               cnt++;
            }

            //현재 칸에서 4방향 탐색, 90도 회전하면서 청소할 수 있는 칸 있으면 청소
            boolean moved = false;
            for(int i=0; i<4; i++){
                robotD = (robotD-1+4)%4;
                int nr = robotR + dy[robotD];
                int nc = robotC + dx[robotD];

                if(room[nr][nc] == 0){
                    robotR = nr;
                    robotC = nc;
                    moved = true;
                    break;
                }
            }
            if(moved) continue;

            //빈칸 없었을 때 후진
            int bd = (robotD+2)%4;
            int _br = robotR+dy[bd];
            int _bc = robotC+dx[bd];

            if(room[_br][_bc] == 1) break;

            robotR = _br;
            robotC = _bc;

        }
        System.out.println(cnt);

    }
}