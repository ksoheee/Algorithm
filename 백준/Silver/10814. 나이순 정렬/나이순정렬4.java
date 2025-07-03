//방법 4 ; [StringBuilder[] + Scanner + StringBuilder]
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        
        StringBuilder[] p = new StringBuilder[201];
        for(int i=0; i<p.length; i++) p[i]=new StringBuilder();
        
        for(int i=0; i<n; i++){
            int age=sc.nextInt();
            String name=sc.next();
            //카운팅 정렬: 나이를 index로 하여 해당 배열에 나이와 이름을 append()한다.
            p[age].append(age).append(" ").append(name).append("\n");
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder val: p){
            sb.append(val);
        }System.out.println(sb);
    }
}
