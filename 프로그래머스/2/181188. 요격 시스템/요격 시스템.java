import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
                
        });
        int preStart = targets[0][0];
        int preEnd = targets[0][1];
        
        int curStart;
        int curEnd;
        for(int[] target: targets){
            if(answer == 0){
                answer ++;
                continue;
            }
            curStart=target[0];
            curEnd=target[1];
            if(preStart <= curStart && curStart < preEnd){
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, curEnd);
            }else{
                preStart = curStart;
                preEnd = curEnd;
                answer++;
            }
        }        
            
        return answer;
    }
}