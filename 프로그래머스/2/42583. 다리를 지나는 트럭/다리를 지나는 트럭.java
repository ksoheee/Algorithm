import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentWeight =0;
        int len = truck_weights.length;
        
        Queue<Integer> q = new LinkedList<>();
        
        //다리에 올라갈 수 있는 트럭
        for(int i=0; i<bridge_length; i++){
            q.offer(0);
        }
        
        int c = 0;
        while(c<len){
            answer++;
            
            //다리 빠져나감
            int truck = q.poll();
            currentWeight-=truck;
            
            //무게가 괜찮다면 트럭 건너기
            if(currentWeight+truck_weights[c]<=weight){
                q.offer(truck_weights[c]);
                currentWeight+=truck_weights[c];
                c++;
            }//아니면 빈 공간 
            else{
                q.offer(0);
            }
            
        }
        
        
        
        return answer+bridge_length;
    }
}