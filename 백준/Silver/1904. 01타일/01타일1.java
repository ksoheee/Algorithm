import java.util.*;
import java.io.*;

public class Main{
    public static int[] dp= new int[1000001];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.print(tile(N));
    }
    public static int tile(int v){
        if(v==1){
            return 1;
        }
        if(v==2){
            return 2;
        }
        int val1= 1;
        int val2 =2;
        int sum=0;
        for(int i=2; i<v; i++){
            sum=(val1+val2) % 15746;
            val1=val2;
            val2=sum;
        }
        return sum;
    }
    
}
