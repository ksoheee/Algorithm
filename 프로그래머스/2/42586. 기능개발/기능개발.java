import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        
        //배포 가능일 계산
        for(int i=0; i<progresses.length; i++){
            int persent = 100-progresses[i];
            int days = persent%speeds[i]==0 ? persent/speeds[i] : persent/speeds[i]+1;
            q.offer(days);
        }
        
        List<Integer> list = new ArrayList<>();
        int first = q.poll();
        int cnt = 1;
        while(!q.isEmpty()){
            int next = q.poll();
            //앞의 배포일 보다 작거나 같을 때
            if(first>=next){
                cnt++;
            }
            else{
                list.add(cnt);
                first=next;
                cnt=1;
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}