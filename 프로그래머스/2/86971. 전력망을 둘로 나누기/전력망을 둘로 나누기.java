import java.util.*;
class Solution {
    static boolean[] visited;
    static List<Integer>[] graph; //리스트들을 여러개 가지고 있는 배열 
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();
        for(int[] wire : wires){
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);       
        }
        
        for(int[] wire : wires){
            visited = new boolean[n+1];
            int cnt = dfs(wire[0],wire[0],wire[1]);
            int other = n - cnt;
            answer = Math.min(answer, Math.abs(cnt - other));
        }
        return answer;
    }
    static int dfs(int cur, int cur1, int cur2){
        visited[cur] = true;
        int cnt =1;
        
        for(int next: graph[cur]){
            if(!visited[next]){
                if((cur == cur1 && next == cur2) ||(cur == cur2 && next == cur1) ) continue;
                cnt += dfs(next,cur1,cur2);
            }
        }    
        return cnt;
    }
}
