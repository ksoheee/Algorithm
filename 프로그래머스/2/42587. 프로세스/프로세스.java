import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> q = new LinkedList<>();
        
        //(우선순위,인덱스) 형태로 큐에 저장
        for(int i=0; i<priorities.length; i++){
            q.offer(new Process(i, priorities[i]));
        }
        
        while(!q.isEmpty()){
            Process current = q.poll();
            //더 높은 우선순위 여부 확인
            boolean hasHigherPriority = false;
            for(Process p : q){
                if(current.priority<p.priority){
                    hasHigherPriority = true;
                    break;
                }
            }
            //더 높은 우선순위 있다면 맨뒤로 
            if(hasHigherPriority){
                q.offer(new Process(current.index, current.priority));
            }
            //없다면 프로세스 실행하고 카운트 증가
            else{
                answer++;
                if(current.index == location){
                    return answer;
                }
            }
        }
        return -1;
    }
    static class Process{
        int index;
        int priority;
        Process(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }
}