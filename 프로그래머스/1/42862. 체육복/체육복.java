import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int reserveLen = reserve.length;
        int lostLen = lost.length;
        int cnt = n-lostLen;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //여벌 체육복 있는애가 도난 당한 경우
        for(int i=0; i<lostLen; i++){
            for(int j=0; j<reserveLen; j++){
                if(lost[i]==reserve[j]){
                    lost[i]=-1;
                    reserve[j]=-1;
                    cnt++;
                    break;
                }
            }
        }
        
        for(int i=0; i<lostLen; i++){
            for(int j=0; j<reserveLen; j++){
                if(lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]){
                    cnt++;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        return cnt;
    }
}