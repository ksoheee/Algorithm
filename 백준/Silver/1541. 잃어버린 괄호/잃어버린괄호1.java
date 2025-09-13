import java.util.*;
import java.io.*;
public class Main {   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(),"-");
        
        int sum = Integer.MAX_VALUE;
        while(st1.hasMoreTokens()){
            int tmp =0;
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"+");
            
            while(st2.hasMoreTokens()){
                tmp += Integer.parseInt(st2.nextToken());
            }
            if(sum == Integer.MAX_VALUE){
                sum = tmp;
            }else{
                sum -=tmp;
            }
        }
        System.out.println(sum);
    }
}
