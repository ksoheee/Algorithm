import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int R = sc.nextInt();
            String str= sc.next();
            for(int j=0; j<str.length(); j++) {
                for(int m=0; m<R; m++){
                    System.out.print(str.charAt(j));
                }
            }System.out.print("\n");
        }
    }
}