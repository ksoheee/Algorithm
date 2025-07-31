import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        int min=0;

        int num1 =Integer.parseInt(br.readLine());
        int num2 =Integer.parseInt(br.readLine());

        for(int i=num1; i<=num2; i++){
            for(int j=2; j<=i; j++){
                if(i==j){
                    if(sum==0) min=i;
                    sum += i;
                }
                if(i%j==0){
                    break;
                }
            }
        }
        if(min==0 || sum==0) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}