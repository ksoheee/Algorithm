import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quarter=0, dime=0, nickel=0, penny=0;
        int T = sc.nextInt();
        int C;
        for(int i=0; i<T; i++){
            C = sc.nextInt();
            if(C/25>0){//0.25 달러이상
                quarter=C/25;
                C-=quarter*25;
            }if(C!=0 && C/10>0){
                dime=C/10;
                C-=dime*10;
            }if(C!=0 && C/5>0){
                nickel=C/5;
                C-=nickel*5;
            }if(C!=0 && C/1>0){
                penny=C/1;
                C-=penny*1;
            }
            System.out.println(quarter+" "+dime+" "+nickel+" "+penny);
            quarter=0; dime=0; nickel=0; penny=0;
        }
    }
}