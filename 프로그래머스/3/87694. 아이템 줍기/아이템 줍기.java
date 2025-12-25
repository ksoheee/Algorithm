import java.util.*;
class Solution {
    static class Rect{
        int x1,y1,x2,y2;
        Rect(int x1, int y1, int x2, int y2){
            this.x1=x1;
            this.y1=y1;
            this.x2=x2;
            this.y2=y2;
        }
        
    }
    static List<Rect> rectList;
    static int[][] road;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        rectList= new ArrayList<>();
        road = new int[102][102];
        for(int i=0; i<rectangle.length; i++){
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            
            for(int j=y1; j<=y2; j++){
                for(int k=x1; k<=x2; k++){
                    road[j][k]=-1;
                }
            }
            rectList.add(new Rect(x1,y1,x2,y2));
        }
        int answer = bfs(characterY*2,characterX*2,itemY*2, itemX*2);
        return answer;
    }
    static int bfs(int y, int x, int iY, int iX){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x,1});
        road[y][x]=1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int py = cur[0];
            int px = cur[1];
            int dist = cur[2];
            
            if(py==iY && px ==iX) return dist/2;
            
            for(int i=0; i<4; i++){
                int ny = py+dy[i];
                int nx = px+dx[i];
                
                if(road[ny][nx]<0 && isBoundary(ny,nx)){
                    q.offer(new int[]{ny,nx,dist+1});
                    road[ny][nx]=dist+1;
                }
            }
        }
        return -1;
    }
    static boolean isBoundary(int y, int x){
        for(Rect r : rectList){
            if(r.x1 <x && r.y1<y && x<r.x2 && y<r.y2 ) return false; 
        }
        return true;
    }
}