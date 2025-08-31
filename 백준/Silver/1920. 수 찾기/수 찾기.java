import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = N-1;

            while (left<=right) {
                int mid = (left+right)/2;
                if (arr1[mid] < arr2[i]) {
                    left = mid + 1;

                } else if (arr1[mid] > arr2[i]) {
                    right = mid - 1;
                } else if(arr1[mid] == arr2[i]) {
                    sb.append(1 + "\n");
                    break;
                }
            }
            if(left>right){
                sb.append(0 + "\n");
            }
        }
        System.out.print(sb);
    }
}

