import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt =0;
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        while(pq.peek()<K){
            if(pq.peek()<K){
                int first = pq.poll();
               if(pq.size()<1) return -1;
                int second = pq.poll()*2;
                int sum = first + second;
                cnt++;
                pq.add(sum);
            }
        }
        return cnt;
    }
}