import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] A = new int[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            A[i]=Integer.parseInt(st.nextToken());
        }
        Integer[] B = new Integer[n];
        for(int i=0;i<n;i++){
            B[i]=A[i];
        }
        Arrays.sort(B,Collections.reverseOrder());
        int weight = 0;
        for(int i=0;i<n;i++){
            weight = Math.max(weight,B[i]*(i+1));
        }
        System.out.println(weight);

    }

}