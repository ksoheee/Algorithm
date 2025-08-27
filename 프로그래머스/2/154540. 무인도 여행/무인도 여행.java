import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static String[] maps;
    static int X;
    static int Y;
    
    public int[] solution(String[] maps) {
        this.maps = maps;
        X = maps.length;           //행
        Y = maps[0].length();      //열

        visited = new boolean[X][Y];
        List<Integer> result = new ArrayList<>();
        
        //모든 좌표를 돌면서 섬 탐색
        for(int i=0; i<X; i++){
            for(int j=0; j<Y; j++){
                if(!visited[i][j] && maps[i].charAt(j)!='X'){
                   result.add(BFS(i,j));
                }
            }
        }
        //result의 길이가 0이면 -1
        if(result.isEmpty()) return new int[] {-1};
        //배열로 바꾸기 
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i]=result.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    public static int BFS(int x, int y){
        int total =0;
        
        visited[x][y]=true;    
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
            
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            total += maps[nowX].charAt(nowY)-'0';
            
            for(int i=0; i<4; i++){
                int nextX = nowX+ dx[i];
                int nextY = nowY + dy[i];
                
                if(nextX< 0 || nextY < 0 || nextX>= X || nextY >= Y) continue;
                if(visited[nextX][nextY]==true)  continue;
                if(maps[nextX].charAt(nextY) == 'X')   continue;
                q.add(new int[] {nextX, nextY});
                visited[nextX][nextY]=true;
   
            }           
        }
        return total;
    }
}