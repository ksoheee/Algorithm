import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        //끝나는 점 기준으로 정렬
        Arrays.sort(routes, (a,b)->(a[1]-b[1]));
        
        int current = routes[0][1]; //첫 번째 끝점
        for(int i=0; i<routes.length; i++){
            if(current < routes[i][0]){
                answer++;
                current = routes[i][1];
            }
        }
        return answer;
    }
}