import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[N][2];
        int[] level = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]= Integer.parseInt(st.nextToken());
            arr[i][1]= Integer.parseInt(st.nextToken());
            level[i] = 1;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][0] <arr[j][0]){
                    if(arr[i][1] <arr[j][1]){
                        level[i] += 1;
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            System.out.print(level[i]+" ");

        }
    }
}