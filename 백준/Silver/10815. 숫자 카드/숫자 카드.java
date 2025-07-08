import java.sql.Array;
import java.util.*;import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i]=sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++){
            arr2[i]=sc.nextInt();
        }//정렬
        Arrays.sort(arr1);

        int left=0; int right =n-1;
        int mid=0;

        for(int j=0; j<m; j++){
            left=0; right=n-1; mid=0;
            while(left<=right){
                mid=(left+right)/2;                
                if(arr1[mid]<arr2[j]){
                    left=mid+1;
                }else if(arr1[mid]>arr2[j]){
                    right=mid-1;
                }else if(arr1[mid]==arr2[j]){
                    System.out.print("1 ");
                    break;
                }
            }if(left>right) System.out.print("0 ");
        }
    }
}
