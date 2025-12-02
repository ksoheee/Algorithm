import java.util.*;
class Solution {
    boolean[] visited;
    int result;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        permutation(k, 0, dungeons);
        
        return result;
    }
    //순열의 조합
    public void permutation(int k, int cnt, int[][] dungeons){
        result = Math.max(cnt, result);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0]<=k){
                visited[i]= true;
                permutation(k-dungeons[i][1], cnt+1, dungeons);
                
                visited[i]= false;
            }
        }
    }
}