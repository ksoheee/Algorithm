import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M=sc.nextInt();
        int N=sc.nextInt();
        int time = M*60+N;
        if(time<45) time=24*60+N;
        time -=45;
        System.out.print(time/60+" " +time%60);

    }
}