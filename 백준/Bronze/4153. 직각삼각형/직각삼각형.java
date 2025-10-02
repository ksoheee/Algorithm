import java.util.*;
import java.io.*;
public class Main {   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            
            int a = arr[0]*arr[0];
            int b = arr[1]*arr[1];
            int c = arr[2]*arr[2];
            
            if(a == 0 && b== 0 && c == 0 ) break;
            if(a+b==c)    System.out.println("right");
            else          System.out.println("wrong");           
        }
    }
}
