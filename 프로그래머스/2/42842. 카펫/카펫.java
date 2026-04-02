import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        //가로>=세로, 세로>=3
        //테두리만 갈색
        //노랑색이 소수인 경우에 노랑의 세로는 1
        
        List<Integer> divisor = new ArrayList<>();
        List<int[]> muls = new ArrayList<>();
        //약수 구하기
        for(int i=yellow; i>0; i--){
            if(yellow % i == 0) divisor.add(i);
        }
        //약수 중 큰수 부터 약수 * x = 노랑이 되는 짝을 찾아서 리스트에 저장
        for(int i : divisor){
            int j = yellow/i;
            if(j>i) break;
            muls.add(new int[]{i,j});
        }
        
        List<Integer> answer = new ArrayList<>();
        // 갈색(노랑가로+2, 노랑세로+2)
        for(int[] mul : muls){
            int b1 = mul[0]+2;
            int b2 = mul[1]+2;
            
            if((b1*b2)-(mul[0]*mul[1])==brown){
                answer.add(b1);
                answer.add(b2);
                break;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray(); 
    }
}