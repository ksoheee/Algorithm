import java.util.*;import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int cnt = 1;
        int tmp = 1;
        int num = 666;
        while (cnt != s) {
            num++;
            //int형인 num을 String으로 변환한 뒤, "666"이란 문자열 있는지 검사
            if (String.valueOf(num).contains("666")) {
                cnt++;
            }
        }
        System.out.println(num);
    }
}