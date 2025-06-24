import java.util.*;import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] arr = new int[s.length()];
        int tmp=0;
        for(int i=0;i<s.length();i++){
            arr[i]=s.charAt(i)-'0';
        }
        for(int i=0;i<s.length();i++){
            for(int j=i; j<s.length();j++){
                if(arr[i]<arr[j]){
                    tmp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=tmp;
                }
            }
        }for(int e: arr) System.out.print(e);

    }
}