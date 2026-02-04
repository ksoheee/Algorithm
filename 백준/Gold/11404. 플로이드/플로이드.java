import java.util.*;
import java.io.*;

public class Main{
    static int[][] dist;
    static final int INF = 1_000_000_000;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i]=0;
        }


        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(dist[a][b] < c) continue;
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
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(dist[i][j]==INF) dist[i][j]=0;
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }
}