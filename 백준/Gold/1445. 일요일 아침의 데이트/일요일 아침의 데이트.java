import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] forest;
    static int n,m;
    static boolean[][] nextG;   //쓰레기 인접칸
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //입력
        forest = new char[n][m];
        int sr=0, sc =0; int fr =0, fc = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                forest[i][j] = str.charAt(j);
                if(forest[i][j] == 'S') {
                    sr=i; sc=j;
                }else if(forest[i][j] == 'F') {
                    fr=i; fc=j;
                }
            }
        }

        //쓰레기가 인접한 칸
        nextG = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(forest[i][j] == 'g') {

                    for(int k=0; k<4; k++){
                        int nr = i + dy[k];
                        int nc = j + dx[k];

                        if(nr<0 || nc<0 || nr>=n || nc>= m) continue;
                        //"칸이 비어있을 때!" 옆에 쓰레기가 비어있어야지만 쓰레기 옆으로 지나 간 것
                        if(forest[nr][nc]=='.') nextG[nr][nc] = true;

                    }
                }
            }
        }

        //탐색
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][][] best = new int[n][m][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Arrays.fill(best[i][j], Integer.MAX_VALUE);
            }
        }
        best[sr][sc][0] = 0;
        best[sr][sc][1] = 0;
        pq.offer(new Node(sr, sc, 0, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.r == fr && cur.c == fc) {
                System.out.println(cur.g+" "+cur.ng);
                return;
            }

            //현재 쓰레기 수가 더 크다면
            if(best[cur.r][cur.c][0]< cur.g) continue;
            //쓰레기 수가 같다면 인접한 횟수 비교
            if(best[cur.r][cur.c][0] == cur.g && best[cur.r][cur.c][1]< cur.ng) continue;

            for(int i = 0; i < 4; i++) {
                int nr = cur.r + dy[i];
                int nc = cur.c + dx[i];

                if(nr<0 || nc<0 || nr>=n || nc>=m) continue;

                int ng = cur.g;
                int nng = cur.ng;

                if(forest[nr][nc]=='g') ng++;
                else if(nextG[nr][nc]) nng++;

                //현재 경로를 통한 쓰레기 수가 저장되어 있는 쓰레기 수보다 작으면
                //쓰레기 수가 같다면 쓰레기와 인접한 수가 작다면
                if(ng < best[nr][nc][0] ||
                  (ng == best[nr][nc][0] && nng<best[nr][nc][1])
                ){
                    pq.offer(new Node(nr, nc, ng, nng));
                    best[nr][nc][0]=ng;
                    best[nr][nc][1]=nng;
                }
            }
        }

    }

    static class Node implements Comparable<Node>{
        int r;
        int c;
        int g;
        int ng;
        Node(int r, int c, int g, int ng) {
            this.r = r;
            this.c = c;
            this.g = g;
            this.ng = ng;
        }

        //우선순위 결정
        @Override
        public int compareTo(Node o){
            if(this.g != o.g) return this.g - o.g;
            return this.ng - o.ng;
        }
    }

}