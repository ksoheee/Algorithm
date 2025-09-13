import java.util.*;
import java.io.*;
public class Main {   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(),"-");
        
        int sum = Integer.MAX_VALUE;
        while(st1.hasMoreTokens()){
            int temp=0;
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"+");
            
            while(st2.hasMoreTokens()){
                temp +=Integer.parseInt(st2.nextToken());
            }
            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }else{
                sum -= temp;
            }  
        }
        System.out.println(sum);
    }
}