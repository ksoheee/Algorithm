import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6,6,5,4,3,2,1};
        int cnt =0;
        int z =0;
        
        HashSet<Integer> set = new HashSet<>();
        for(int w : win_nums){
            set.add(w);
        }
        for(int l : lottos){
            if(l==0) z++;
            else if(set.contains(l)) cnt++;
        }
        int max = rank[z+cnt];
        int min = rank[cnt]; 
        return new int[]{max,min};
    }
}
