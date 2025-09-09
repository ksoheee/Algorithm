class Solution {
    public int solution(int[] players, int m, int k) {
       int answer=0;
       int[] server = new int[24];
        
        for(int i=0; i<24; i++){
            //현재 필요한 서버 
            int needServer=0;
            needServer = players[i]/m;
            
            //현재 사용가능한 서버 수
            int currServer=0;
            for(int j=Math.max(0,i-k+1); j<i; j++){
                currServer += server[j];
            }
            
            int add = Math.max(0,needServer - currServer);
            server[i]=add;
            answer += add; 
        }
        return answer;
    }
}
