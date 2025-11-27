import java.util.*;
class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    boolean[][] visited;
    int r; int c;
    public int solution(int[][] maps) {
        int answer = 0;
        c = maps[0].length;
        r = maps.length;
        visited = new boolean[r][c];
        
        answer = bfs(0,0,maps);
        
        if(answer==1) return -1;
        else          return answer;
        
    }
    public int bfs(int x, int y,int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x]=true;
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            int px = p[1];
            int py = p[0];
            for(int i=0; i<4; i++){
                int nx = px+dx[i];
                int ny = py+dy[i];
                
                if(nx<0 || ny<0 || nx>=c || ny>= r) continue;
                if(visited[ny][nx] || maps[ny][nx]==0) continue;
                visited[ny][nx]=true;
                q.offer(new int[]{ny,nx});
                maps[ny][nx] += maps[py][px]; 
            }
        }
        return maps[r-1][c-1];
    }
}