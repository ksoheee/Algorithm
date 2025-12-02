import java.util.*;
class Solution {
    boolean[] visited;
    List<List<Integer>> list = new ArrayList<>();
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        visited = new boolean[len];
        
        permutation(new ArrayList<>(), len);
        
        int result = 0;
        
        for(List<Integer> d : list){
            int fatigue = k;
            int cnt = 0;
            for(int i : d){
                if(dungeons[i][0]>fatigue) break;
                fatigue -= dungeons[i][1];
                cnt++;
            }
            result = Math.max(cnt, result);
        }
        return result;
    }
    //순열의 조합
    public void permutation(List<Integer> combo, int len){
        if(combo.size() == len){
            list.add(new ArrayList<>(combo));
            return;
        }
        for(int i=0; i<len; i++){
            if(!visited[i]){
                visited[i]= true;
                combo.add(i);
                permutation(combo, len);
            
                combo.remove(combo.size()-1);
                visited[i]= false;
            }
        }
    }
}
