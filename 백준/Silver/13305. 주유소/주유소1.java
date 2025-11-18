import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[] load = new long[n];
        long[] cost = new long[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n-1;i++){
            load[i]= Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            cost[i]= Integer.parseInt(st.nextToken());
        }
        long minCost = cost[0];
        long total = 0;
        for(int i=0;i<n-1;i++){
            if(cost[i]<minCost){
                minCost = cost[i];
            }
            total+=minCost*load[i];
        }
        System.out.println(total);
    }
}
