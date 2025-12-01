import java.util.*;
class Solution {
    char[][] place;
    boolean[][] visited;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int t=0; t<5; t++){
            place = new char[5][5];
            
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    place[i][j]=places[t][i].charAt(j);
                }
            }
            
            boolean ok = true;
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(place[i][j]=='P'){
                        if(!BFS(i,j,0)){
                            ok = false;
                            break;
                        }
                    }
                }
                if(!ok) break;
            }
            answer[t] = ok ? 1: 0;
        }
        return answer;
    }
    public boolean BFS(int y, int x,int depth){
        visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x,depth});
        visited[y][x] = true;
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            int py = p[0];
            int px = p[1];
            int pd = p[2];
            
            for(int i=0; i<4; i++){
                int ny = py+dy[i];
                int nx = px+dx[i]; 
                
                //범위밖, 이미 방문
                if(ny<0 || nx<0 || ny>=5 || nx>=5) continue;
                if(visited[ny][nx]) continue;
                
                //파티션
                if(place[ny][nx]=='X') continue;
                
                //범위 밖
                int nd = pd+1;
                if(nd>2) continue;
                
                //실패
                if(place[ny][nx]=='P' && nd==1) return false;
                
                if(place[ny][nx]=='P' && nd==2){
                    //직선 거리면 실패
                    if(ny==y || nx==x) return false;
                    //대각선이라면 지나가는 거리가 X여야 함
                    if(!(place[y][nx]=='X' && place[ny][x]=='X')) return false;
                }
                //O일때만 지나가야함 거리가 2이상인 P도 삽입될 수 있으므로
                if(place[ny][nx]=='O'){
                    visited[ny][nx]=true;
                    q.offer(new int[]{ny,nx, nd});
                }

            }
        }
        return true;
    }
}
