import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt =0;
        for(int sco: scoville){
            pq.offer(sco);
        }
        while(pq.peek()<K && pq.size()>1){
            int first = pq.poll();
            int second = pq.poll()*2;
            int sum = first + second;
            cnt++;
            pq.add(sum);          
        }
        return pq.peek()<K ?  -1 :cnt;
    }
}
