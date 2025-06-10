import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt(); //공백기준
        int min = sc.nextInt();
        int calc = hour *60 +min; //분으로 환산
        if(calc <45){
            calc = 24 *60+min; //45미만에 대한 처리
        }calc -=45;

        System.out.println((calc/60)+" "+ (calc %60));


    }
}