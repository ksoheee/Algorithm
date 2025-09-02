import java.util.*;
import java.io.*;
public class Main {
    static boolean[][] visited;
    static String[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열

        int x = 0,y=0;
        arr = new String[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j]=str.charAt(j)+"";
                if(arr[i][j].equals("I")){
                    x=i; y=j;
                }
            }
        }
        int cnt = bfs(x,y);
        if(cnt==0) System.out.println("TT");
        else System.out.println(bfs(x,y));
    }
    static int bfs(int x, int y){
        visited[x][y]=true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX>=N || nextX<0 || nextY>=M || nextY<0) continue;
                if(visited[nextX][nextY]) continue;
                if(arr[nextX][nextY].equals("X")) continue; //벽
                if(arr[nextX][nextY].equals("P")) cnt++;
                q.offer(new int[]{nextX,nextY});
                visited[nextX][nextY]=true;
            }
        }
        return cnt;
    }
}