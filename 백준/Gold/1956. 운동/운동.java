import java.util.*;
import java.io.*;

public class Main{
    static int[][] dist;
    static final int INF = 1_000_000_000;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dist = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(dist[i], INF);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b]=c;
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                if(dist[i][k]==INF) continue;
                int ik = dist[i][k];
                for(int j=1; j<=n; j++){
                    if(dist[k][j]==INF) continue;
                    int nd = ik + dist[k][j];
                    if(dist[i][j] > nd) dist[i][j]=nd;
                }
            }
        }
        int ans = INF;
        for(int k=1; k<=n; k++){
            ans = Math.min(ans, dist[k][k]);
        }
        if(ans == INF) ans = -1;
        System.out.println(ans);


    }
}