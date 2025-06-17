import java.util.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int[] arr= new int[num];
        int cnt=0;
        for(int i=2; i<=num; i++){
            if(num%i==0){
                arr[cnt]=i;
                //System.out.println("cnt:" +cnt+" i:"+i);
                num /=i;
                //System.out.println("num/=i : "+num);
                cnt++;
                i=1;
            }
        }//System.out.println(cnt);
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==0) continue;
            System.out.println(arr[i]);
        }
    }
}