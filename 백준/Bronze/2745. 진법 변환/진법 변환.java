import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N=sc.next();
        int B = sc.nextInt();
        int x=0;
        long y=0;
        int num=1;
        for(int j=1; j<N.length(); j++) {
             num*=B;
        } 
        for(int i=0; i<N.length(); i++){
            if('A'<=N.charAt(i) && N.charAt(i)<='Z'){
                x=N.charAt(i)-55;

            }else x=N.charAt(i)-'0';            
            y+= x* num;         
            num /=B;            
        }
        System.out.print(y);
    }
}