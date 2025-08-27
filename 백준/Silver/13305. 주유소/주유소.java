import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] oil = new int[N-1];
        int[] price = new int[N];

        int totalOil=0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N-1; i++){
            oil[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            price[i]=Integer.parseInt(st.nextToken());
        }

        int maxOil = price[0];
        for(int i=0; i<N-1; i++){
            if(maxOil>price[i]){
                maxOil=price[i];
            }
            totalOil += maxOil*oil[i];
        }
        System.out.println(totalOil);

    }
}