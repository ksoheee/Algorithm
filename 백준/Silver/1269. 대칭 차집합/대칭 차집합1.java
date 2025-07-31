import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for(int i=0; i<A; i++){
            setA.add(sc.nextInt());
        }
        for(int i=0; i<B; i++){
            setB.add(sc.nextInt());
        }
        int cnt =0;
        for(int num: setA){
           if(!setB.contains(num)) cnt++;
        }
        for(int num: setB){
            if(!setA.contains(num)) cnt++;
        }
        System.out.println(cnt);
    }
}
