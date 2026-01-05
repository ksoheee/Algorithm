import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] lab;
    static List<int[]> virusList = new ArrayList<>();
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];

        //i 행 , j 열
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j] == 2) virusList.add(new int[]{i, j}); //바이러스 좌표 저장
            }
        }
        buildWall(0);
        System.out.println(max);
    }
    static void buildWall(int cnt){
        if(cnt==3){
            //바이러스 퍼트리기
            spreadVirus();
            return;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(lab[i][j]==0){
                    lab[i][j]=1;
                    buildWall(cnt+1);
                    lab[i][j]=0;
                }
            }
        }
    }
    static void spreadVirus(){
        //바이러스 퍼짐
        int[][] copy = new int[n][m];
        for(int i = 0; i < n; i++){
            copy[i]=lab[i].clone();
        }

        Queue<int[]> queue = new LinkedList<>();

        //바이러스가 있는 좌표 저장
        for(int i = 0; i < virusList.size(); i++){
            queue.add(virusList.get(i));
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];

            for(int k = 0; k<4; k++){
                int ny = i + dy[k];
                int nx = j + dx[k];

                if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
                if(copy[ny][nx]==0){
                    copy[ny][nx] = 2;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
        max = Math.max(max,safeArea(copy));
    }
    static int safeArea(int[][] map){
        int cnt = 0;
        for(int i=0; i< n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
}