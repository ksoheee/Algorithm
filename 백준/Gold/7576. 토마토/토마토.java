import java.util.*;
import java.io.*;
public class Main {
    static int[][] tomato;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N= Integer.parseInt(st.nextToken());    //열
        M = Integer.parseInt(st.nextToken());    //행

        tomato = new int[M][N];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                tomato[i][j]=Integer.parseInt(st.nextToken());
                if(tomato[i][j]==1){
                    q.add(new int[] {i,j});
                }
            }
        }

        int days = bfs(q);

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(tomato[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(days);

    }
    static int bfs(Queue<int[]> q){
        int day = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){ //
                int[] pre = q.poll();
                int pR = pre[0];
                int pC = pre[1];

                for(int j=0; j<4; j++){
                    int nR = pR+dx[j];
                    int nC = pC+dy[j];

                    if(nR<0 || nC<0 || nR>=M || nC>=N ) continue;
                    if(tomato[nR][nC]==1 || tomato[nR][nC]==-1) continue;
                    q.offer(new int[]{nR,nC});
                    tomato[nR][nC]=1;
                }
            }
            day++;
        }
        return day;
    }
}