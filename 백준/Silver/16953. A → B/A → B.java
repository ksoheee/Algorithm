import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int cnt = 1;
        while(B>A){
            if(B%10 == 1){
                B/=10;
            }
            else if(B%2==0){
                B/=2;
            }
            else{
                cnt = -1;
                break;
            }
            cnt++;
        }
        if(B!=A){
            System.out.println(-1);
        }else{
            System.out.println(cnt);
        }
    }

}