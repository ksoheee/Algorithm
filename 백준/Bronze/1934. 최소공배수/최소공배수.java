import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c = gcd(a,b);
            sb.append(a*b/c+" ");
        }
        System.out.println(sb);
    }
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}