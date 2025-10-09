import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<n; i++){
            //가격이 이전보다 작아졌다면, 이전 시점부터 가격이 떨어진것으로 시간 계산 후 스택에서 제거
            while(!s.isEmpty() && prices[i]<prices[s.peek()]){
                int idx = s.pop();
                answer[idx] = i-idx;
            }
            //가격이 떨어지지 않은 시점들의 인덱스 저장
            s.push(i);
        }
        //끝가지 가격이 떨어지지 않은 경우
        while(!s.isEmpty()){
            int idx = s.pop();
            answer[idx] = n-idx-1;
        }
        return answer;
    }
}