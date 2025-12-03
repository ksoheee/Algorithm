import java.util.*;
class Solution {
    boolean[][] visited;
    int[] dy ={-1,1,0,0};
    int[] dx = {0,0,-1,1};
    int M,N;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        M = m; N = n;
        visited = new boolean[m][n];

        for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[0].length; j++){
                if(!visited[i][j] && picture[i][j]!=0){
                    maxSizeOfOneArea=Math.max(maxSizeOfOneArea,bfs(i,j, picture[i][j],picture));
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public int bfs(int y, int x, int t, int[][] picture){
        Queue<int[]> q = new LinkedList<>();
        visited[y][x]=true;
        q.offer(new int[]{y,x,t});
        int cnt = 1;
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            int py = p[0];
            int px = p[1];
            int tmp = p[2];
            
            for(int i=0; i<4; i++){
                int ny = py+dy[i];
                int nx = px+dx[i];
                
                if(ny<0 || nx<0 || ny>=M || nx>=N || visited[ny][nx]) continue;
                
                //같은 숫자가 아니면 
                if(picture[ny][nx]!=tmp) continue;
                
                visited[ny][nx]= true;
                q.offer(new int[]{ny,nx,tmp});
                cnt++;
            }
        }
        return cnt;
    }
}
