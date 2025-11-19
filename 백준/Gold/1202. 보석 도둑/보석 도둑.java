import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewel = new int [N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        //정렬 가벼운보석 순
        Arrays.sort(jewel, (a,b)->a[0]-b[0]);

        int[] weight = new int[K];
        for(int i=0;i<K;i++){
            weight[i] = Integer.parseInt(br.readLine());
        }
        //정렬 작은가방 순
        Arrays.sort(weight);

        //가방 순서대로 돌면서 담을 수 있는 보석을 후보에
        long sum = 0;
        int j=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<K;i++){
            int bagWeight = weight[i];
            //이번 가방에 담을 수 있는 보석 모두 후보에 넣기
            while(j<N && jewel[j][0]<=bagWeight){
                pq.offer(jewel[j][1]);
                j++;
            }
            if(!pq.isEmpty()){
                sum+=pq.poll();
            }
        }
        System.out.println(sum);
    }

}