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
        int sum = 0; //사람별 대기시간 총합
        int pre = 0; //이전까지 대기시간의 누적합
        for(int i=0; i<N; i++){
            sum += pre + arr[i]; //이전까지 대기시간과 현재 대기시간을 더한다.
            
            pre += arr[i]; //이전가지 누적합에 걸리는 시간에 현재 걸리는 시간을 더한다.
        }
        System.out.println(sum);
    }
}