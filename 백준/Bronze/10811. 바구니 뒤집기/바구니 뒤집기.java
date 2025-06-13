import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<arr.length; i++) {
            arr[i]=i+1;          
        }
        int i,j;
        int tmp;
        for(int k=0; k<M; k++){
            i=sc.nextInt()-1;
            j=sc.nextInt()-1;
            while(i<j){                
                tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                i++; j--;
            }
        }
        for(int m=0; m<arr.length; m++){
            System.out.print(arr[m]+" ");
        }
    }
}