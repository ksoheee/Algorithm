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

        int cnt = 1;
        //처음 청소기 위치 청소
        room[robotR][robotC] = 2;
        while(true){
            int nclean = 0;

            int nr = robotR, nc = robotC, nd = robotD;

            //현재칸 주변 4칸중 청소되지 않은 칸이 있는지 확인
            for(int i=0; i<4; i++){
                nr = robotR+dy[i];
                nc = robotC+dx[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m && room[nr][nc]==0){
                    break;
                }
                nclean++;
            }

            //빈칸이 없는 경우 후진
            if(nclean==4){
                if(robotD==0){
                   nr = robotR+1;
                   nc = robotC;
                }else if(robotD==1){
                    nr = robotR;
                    nc = robotC-1;
                }else if(robotD==2){
                    nr = robotR-1;
                    nc = robotC;
                }else if(robotD==3){
                    nr = robotR;
                    nc = robotC+1;
                }
                //뒤로 갔는데 벽이면 끝
                if(room[nr][nc]==1) break;
                //벽이 아니면 청소 안되있으면 청소 후 빈칸있는지 탐색
                //청소 되어있으면 탐색만
                if(room[nr][nc]==0) {
                    room[nr][nc] = 2;
                    cnt++;
                }
                robotR = nr;
                robotC = nc;
            }
            //빈칸이 있는 경우
            else{
                //빈칸을 찾을때까지 90도 회전
                for(int i=0; i<4; i++){
                    if(nd==0){
                        nd = 3;
                    }else if(nd==1){
                        nd = 0;
                    }else if(nd==2){
                        nd = 1;
                    }else if(nd==3){
                        nd = 2;
                    }
                    nr = robotR + dy[nd];
                    nc = robotC + dx[nd];

                    if(room[nr][nc]==0){
                        room[nr][nc] = 2;
                        cnt++;
                        robotR = nr;
                        robotC = nc;
                        robotD = nd;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);

    }
}