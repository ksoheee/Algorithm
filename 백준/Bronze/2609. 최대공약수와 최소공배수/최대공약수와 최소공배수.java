import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int a= Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        
        int c= gcd(a,b);
        
        System.out.println(c);
        System.out.println(a*b/c);
    }
    public static int gcd(int a, int b){
        while(b!=0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}