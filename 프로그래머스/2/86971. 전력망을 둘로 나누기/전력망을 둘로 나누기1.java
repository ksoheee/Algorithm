import java.util.*;
class Solution {
    static int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        arr = new int[n+1][n+1];   
        
        for(int[] wire: wires){
            arr[wire[0]][wire[1]] =1;
            arr[wire[1]][wire[0]] =1;
        }
        
        int a,b;
        for(int[] wire: wires){
            a=wire[0];
            b=wire[1];
            
            //선 끊기
            arr[a][b]=0;
            arr[b][a]=0;
            
            int answer = Math.min(answer,bfs(n,a));
            
            //선 복구
            arr[a][b]=1;
            arr[b][a]=1;
            
        }
        return answer;
    }
    static int bfs(int n, int a){
        boolean[] visited = new boolean[n+1];
        int cnt =1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        
        while(!q.isEmpty()){
            int target = q.poll();
            visited[target] = true;
            
            for(int i=1; i<=n; i++){
                if(visited[i]) continue;
                if(arr[target][i]) {
                    q.offer(i);
                    visited[i]=true;
                    cnt++;
                }
            }
        }
        return Math.abs(n-2*cnt);
    }
}
