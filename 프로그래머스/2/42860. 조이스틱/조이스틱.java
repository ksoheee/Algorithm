import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int length= name.length();
        int minMove = length-1; //오른쪽으로만 이동했을 때
        
        for(int i=0; i<length; i++){
            char alp = name.charAt(i);
            //상하 이동
            int minUpDown = Math.min(alp-'A','Z'-alp+1);
            answer += minUpDown;
            
            //연속된 A숫자
            int next = i+1;
            while(next<length && name.charAt(next)=='A'){
                next++;
            }
            //오른쪽으로 이동하다가 연속된 A를 만나면 되돌아가는것과 오른쪽로만 가는 횟수중 최소
            minMove = Math.min(minMove, i*2+(length-next));
            //처음부터 돌아가서 연속된 A를 만나기 전까지 처리하고 앞으로 돌아오는 경우
            minMove = Math.min(minMove, (length-next)*2+i);   
        }
        answer += minMove;
        return answer;
    }
}
