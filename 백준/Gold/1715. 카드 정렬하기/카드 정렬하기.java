import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for(int i=0;i<n;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        for(int i=0;i<n-1;i++){
            int tmp = pq.poll()+pq.poll();
            pq.add(tmp);
            sum+=tmp;
        }
        System.out.println(sum);
    }

}
