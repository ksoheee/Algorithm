import java.io.*;
import java.util.*;import java.util.Scanner;
public class Main{
    //a,b,c 중 20을 넘어가면 w(20,20,20)을 호출하고, 0 이하일 경우 1을 반환하기 때문에
    //각 배열의 크기가 (0~20)을 넘기지 않는다.
    static int[][][] dp =new int[21][21][21];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(a == -1 && b== -1 && c==-1){
                break;
            }
            System.out.printf("w(%d, %d, %d) = %d\n",a,b,c,w(a,b,c));
        }

    }
    public static int w(int a, int b, int c){
        //범위를 지정해 주지 않으면 dp배열에서 20보다 큰 값에 접근 하게 되므로 예외가 남 ex)dp[30][2][1]이 !=0이 아닌지 확인하기 위하여 접근
        if(inRange(a,b,c) && dp[a][b][c] != 0) //이미 계산되어 저장되어 있는 경우 해당 값을 바로 반환
            return dp[a][b][c];

        if(a<=0 || b <=0 || c<=0){
            return 1;
        }
        //a,b,c중 하나라도 20을 넘어가면 w(20,20,20)을 호출하기 때문에 dp[20][20][20]에 저장하고 반환하면 된다.
        if(a > 20 || b > 20 || c > 20){
            return dp[20][20][20] = w(20,20,20);
        }
        if(a < b && b < c){
            return dp[a][b][c]= w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        return  dp[a][b][c]=w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
    public static boolean inRange(int a, int b, int c){
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}