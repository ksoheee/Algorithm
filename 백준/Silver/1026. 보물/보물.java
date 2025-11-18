import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] A = new int[n];
        int[] B = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            B[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        Arrays.sort(B);
        for(int i=0; i<B.length/2; i++){
            int tmp = B[i];
            B[i]=B[B.length-1-i];
            B[B.length-1-i]=tmp;
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            answer += A[i]*B[i];
        }
        System.out.println(answer);
    }
}