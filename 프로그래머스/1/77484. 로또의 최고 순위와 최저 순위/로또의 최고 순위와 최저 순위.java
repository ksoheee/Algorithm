import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6,6,5,4,3,2,1};
        int cnt =0;
        int z =0;
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    cnt++;
                }
            }
            if(lottos[i]==0) z++;
        }
        answer[0] = rank[z+cnt];
        answer[1] = rank[cnt]; 
        return answer;
    }
}