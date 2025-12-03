import java.util.*;
import java.io.*;

class Main{
    static int[][] town;
    static boolean[][] visited;
    static int n;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int townN = 0; //단지 수
        town = new int[n][n];
        visited = new boolean[n][n];
        List<Integer> house = new ArrayList<>();

        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            for(int j=0; j<n; j++){
                town[i][j]= tmp.charAt(j)-'0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && town[i][j] == 1){
                    house.add(bfs(i,j));
                    townN++;
                }
            }
        }
        System.out.println(townN);
        Collections.sort(house);
        for(int i=0; i<house.size(); i++){
            System.out.println(house.get(i));
        }
    }
    static public int bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        int cnt = 1;

        while(!q.isEmpty()){

            int[] p = q.poll();
            int py = p[0];
            int px = p[1];
            for(int i=0; i<4; i++){
                int ny = py + dy[i];
                int nx = px + dx[i];

                if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
                if(visited[ny][nx] || town[ny][nx]==0) continue;
                visited[ny][nx] = true;
                q.offer(new int[]{ny,nx});
                cnt++;
            }
        }
        return cnt;
    }
}