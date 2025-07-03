import java.util.*;import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        String[][] arr = new String[n][2];
        for(int i=0; i<n; i++){
            arr[i][0]=sc.next();
            arr[i][1]=sc.next();
        }
        Arrays.sort(arr, (o1,o2)->{return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);});
        StringBuilder sbb= new StringBuilder();
        for(int i=0; i<n; i++) sbb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
        System.out.print(sbb);
    }
}