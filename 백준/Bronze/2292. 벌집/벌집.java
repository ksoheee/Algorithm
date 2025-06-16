import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int cnt=1; int tmp=1;
        while(true){
            if(T==1) break;
            tmp += 6*cnt;
            cnt++;
            if(T<=tmp) break;          
        }
        System.out.print(cnt);
    }
}