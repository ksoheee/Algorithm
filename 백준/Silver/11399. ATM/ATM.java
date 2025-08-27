import java.util.*;
import java.io.*;
public class Main {
    static int[] arr;
    static boolean[] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //오름차순 정렬
        int sum = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<=i; j++){
                sum += arr[j];
            }
        }
        System.out.println(sum);
    }
}