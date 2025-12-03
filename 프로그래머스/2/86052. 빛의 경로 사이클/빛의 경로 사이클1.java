import java.util.*;
class Solution {
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    boolean[][][] visited;
    
    public int[] solution(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        int cnt =0; 
        
        List<Integer> answer = new ArrayList<>();
        visited = new boolean[row][col][4];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                for(int k=0; k<4; k++){
                    if(!visited[i][j][k]){
                        cnt =0;
                        int r =i; int c = j; int d=k;
                        
                        while(!visited[r][c][d]){
                            visited[r][c][d]= true;
                            cnt++;
                            
                            char ch = grid[r].charAt(c);
                            if(ch=='L')         d = (d+3)%4;
                            else if(ch=='R')    d = (d+1)%4;
                            
                            r = (r+dr[d]+row)%row;
                            c = (c+dc[d]+col)%col;
                        }
                        
                        answer.add(cnt);
                        
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
        
    }
}
