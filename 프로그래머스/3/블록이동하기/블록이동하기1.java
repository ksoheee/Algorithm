import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    boolean[][][] visited;
    int size;
    int map[][];
    public int solution(int[][] board) {
        size = board.length; 
        map = board;
        
        visited = new boolean[size][size][2];//가로 세로 까지
        Queue<Robot> q = new LinkedList<>();
        q.offer(new Robot(0,0,0,1,0,0));
        
        while(!q.isEmpty()){
            Robot curR = q.poll();
            int r1 = curR.r1;int c1 = curR.c1;
            int r2 = curR.r2;int c2 = curR.c2;
            int status = curR.status;
            int time = curR.time;
            
            if(visited[r1][c1][status] && visited[r2][c2][status]) continue;
            visited[r1][c1][status] = visited[r2][c2][status] = true;
            
            if((r1 == size-1 && c1 == size-1) ||
               (r2 == size-1 && c2 == size-1)) return time;
            
            //상하좌우 또는 회전 동시에 탐색해야되는거아닌가?
            //좌우 상하 되는지
            for(int i=0; i<4; i++){
                int nc1 = c1+dx[i];
                int nc2 = c2+dx[i];
                int nr1 = r1+dy[i];
                int nr2 = r2+dy[i];
                
                if(isRoad(nr1,nc1,nr2,nc2)) q.offer(new Robot(nr1,nc1,nr2,nc2,status, time+1));
            }
            //회전 되는지 
            if(status==0){//가로
                //위로 회전 
                if(isRoad(r1-1,c1,r2-1,c2)){
                    //앞고정
                    q.offer(new Robot(r1, c1, r1-1, c1, 1, time+1));
                    //뒤고정
                    q.offer(new Robot(r2, c2, r2-1, c2, 1, time+1));
                }
                //아래로 회전
                if(isRoad(r1+1,c1, r2+1,c2)){
                    //앞고정
                    q.offer(new Robot(r1, c1, r1+1, c1, 1,time+1));
                    //뒤고정
                    q.offer(new Robot(r2, c2, r2+1, c2 ,1,time+1));
                }
            }else if(status==1){//세로
                //우로 회전
                if(isRoad(r1, c1+1, r2, c2+1)){
                    //위고정
                    q.offer(new Robot(r1, c1, r1, c1+1 ,0,time+1));
                    //아래고정
                    q.offer(new Robot(r2, c2, r2, c2+1 ,0,time+1));       
                }
                //좌로 회전
                if(isRoad(r1, c1-1, r2, c2-1)){
                    //위고정
                    q.offer(new Robot(r1, c1, r1, c1-1, 0,time+1));
                    //아래고정
                    q.offer(new Robot(r2, c2, r2, c2-1 ,0,time+1));
                }
            }
        }
        return -1;
    }
    static class Robot{
        int r1,c1,r2,c2;
        int status;
        int time;
        Robot(int r1,int c1, int r2, int c2, int status, int time){
            this.r1 = r1;this.c1 = c1;
            this.r2 = r2;this.c2 = c2;
            this.status = status; //0가로 1세로
            this.time = time;
        }
    }
    boolean isRoad(int r1,int c1,int r2,int c2){
        if(r1<0 || c1<0 || r2 <0 || c2 <0 || 
           r1>=size || r2>=size || c1>=size || c2>=size|| map[r1][c1]==1|| map[r2][c2]==1) return false;
        return true;
    }
    
}
