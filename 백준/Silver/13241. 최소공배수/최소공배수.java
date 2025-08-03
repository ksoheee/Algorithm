import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        long c = gcd(a,b);
        System.out.println(a*b/c);      
    }
    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b,a%b);        
    }
}