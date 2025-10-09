import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int totalWeight=0;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            q.offer(0);
        }
        
        int index=0;
        while(index<truck_weights.length){
            time++;
            
            //한칸 이동 다리 빠져나감
            totalWeight -= q.poll();
            
            //다음 트럭이 올라갈 수 있는지 확인
            if(totalWeight+truck_weights[index]<=weight){
                q.offer(truck_weights[index]);
                totalWeight += truck_weights[index];
                index++;
            }
            else{
                q.offer(0); //올라갈수 없다면 0으로 한칸 이동
            }
        }
        //마지막 트럭이 지날때 까지 시간 추가
        return time+bridge_length;
    }
}