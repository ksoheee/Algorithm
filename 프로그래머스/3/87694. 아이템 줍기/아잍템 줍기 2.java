import java.util.*;
class Solution {
    static final int MAX = 102;
    static int[][] road;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        road = new int[MAX+1][MAX+1];
        for(int i=0; i<rectangle.length; i++){
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            
            for(int j=y1; j<=y2; j++){
                for(int k=x1; k<=x2; k++){
                    road[j][k]=1;
                }
            }
        }
        //테두리만 남김
        for(int[] r : rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            for(int j=y1+1; j<=y2-1; j++){
                for(int k=x1+1; k<=x2-1; k++){
                    road[j][k]=0;
                }
            }
        }
        
        boolean[][] visited = new boolean[MAX+1][MAX+1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterY*2,characterX*2,1});
        road[characterY*2][characterX*2]=1;
        visited[characterY*2][characterX*2]=true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int py = cur[0];
            int px = cur[1];
            int dist = cur[2];
            
            if(py==itemY*2 && px ==itemX*2){
                answer = dist/2;
                break;
            }
            
            for(int i=0; i<4; i++){
                int ny = py+dy[i];
                int nx = px+dx[i];
                
                if(ny<0 || nx<0 || ny>MAX|| nx>MAX) continue;
                if(visited[ny][nx] || road[ny][nx]!=1)continue;
                
                visited[ny][nx]=true;
                q.offer(new int[]{ny,nx,dist+1});
                road[ny][nx]=dist+1;
                
                
            }
        }
        return answer;
    }
}
