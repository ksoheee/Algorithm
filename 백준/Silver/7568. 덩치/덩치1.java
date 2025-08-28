import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]= Integer.parseInt(st.nextToken());
            arr[i][1]= Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
            int level = 1;
            for(int j=0; j<N; j++){
                if(i == j) continue;  //같은 사람은 비교할 필요 없음
                if(arr[i][0] <arr[j][0] && arr[i][1] <arr[j][1] )
                    level++;
            }
            System.out.print(level+" ");
        }
    }
}
