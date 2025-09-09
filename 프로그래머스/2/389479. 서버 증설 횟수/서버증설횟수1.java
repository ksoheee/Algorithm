import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer=0;
        //만료시간, 증설된 서버 수
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[0]-o2[0]);
        int server=0;
        for(int i=0; i<24; i++){
            while(!pq.isEmpty() && pq.peek()[0]==i){//만료시간과 현재시간이 같다면
                server -= pq.poll()[1];
            }
            int need = players[i]/m;
            int more = server-need;
            if(more<0){
                more = -more;
                server += more;
                answer += more;
                pq.offer(new int[]{i+k, more});
            }
        }
        return answer;
    }
}
