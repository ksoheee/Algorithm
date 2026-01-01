import java.util.*;
import java.io.*;

class Main{
    static final int MIN = 0;
    static final int MAX = 100_000;
    static final int INF = 1_000_000;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //N이 K보다 크면 순간이동은 할 수 없음
        if(N>=K){
            System.out.println(N-K);
            return;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, INF);

        deque.addFirst(N);
        dist[N] = 0;

        while(!deque.isEmpty()){
            int cur = deque.pollFirst();

            if(cur==K) break;

            //순간이동
            int move = cur*2;
            if(move<=MAX && dist[move]> dist[cur]){
                dist[move] = dist[cur];
                deque.addFirst(move);
            }
            int front = cur+1;
            if(front <= MAX && dist[front] > dist[cur]+1){
                dist[front] = dist[cur]+1;
                deque.addLast(front);
            }
            int back = cur-1;
            if(back >= MIN && dist[back] > dist[cur]+1){
                dist[back] = dist[cur]+1;
                deque.addLast(back);
            }
        }
        System.out.println(dist[K]);
    }
}