class Solution {
    int answer;
    int sum;
    int idx;
    public int solution(int[] numbers, int target) {
        idx = 0;
        sum = 0;
        dfs(idx,sum,target,numbers); 

        return answer;
    }
    
    public void dfs(int idx, int sum,int target, int[] numbers){
        int len = numbers.length;
        if(idx == len){
            if(target == sum) answer++;
            return;
        }
        //더하는경우
        dfs(idx+1, sum+numbers[idx],target, numbers);
        //빼는경우
        dfs(idx+1, sum-numbers[idx],target, numbers);
            
    }
  
}