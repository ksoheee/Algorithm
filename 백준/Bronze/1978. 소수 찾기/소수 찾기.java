import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num =Integer.parseInt(st.nextToken());
            for(int j=2; j<=num; j++){
                if(num==j){
                    cnt++;
                }
                if(num%j==0){
                    break;
                }
            }
        }System.out.println(cnt);
    }
}