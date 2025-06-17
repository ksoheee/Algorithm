import java.util.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();

        int re1= Math.min(x - n1, n1);
        int re2=y-n2 >n2 ? n2 : y-n2;
        System.out.println(Math.min(re1,re2));

    }
}