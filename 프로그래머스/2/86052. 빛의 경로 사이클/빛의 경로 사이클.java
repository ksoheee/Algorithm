import java.util.*;
class Solution {
    //상하좌우 0,1,2,3
    int[] L = {2,3,1,0};
    int[] R = {3,2,0,1};
    boolean[][][] visited;
    char[][] arr;
    int r; int c; int d;
    int row; int col;
    int cnt;
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        row = grid.length; col = grid[0].length();
        
        visited = new boolean[row][col][4];
        arr = new char[row][col];
        for(int i=0; i<row; i++){
            arr[i]= grid[i].toCharArray();
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                for(int k=0; k<4; k++){
                    if(!visited[i][j][k]){
                        cnt=0;
                        r = i; c = j; d = k;
                        dfs();
                        
                        answer.add(cnt);
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
        
    }
    public void dfs(){
        while(!visited[r][c][d]){
            visited[r][c][d]=true;
            cnt++;
            char value = arr[r][c];
            
            if(value == 'L'){
                d = L[d];
            }else if(value == 'R'){
                d = R[d];
            }
            move();
        }         
    }
    public void move(){
        if(d==0) r -= 1;
        else if(d==1) r +=1;
        else if(d==2) c -=1;
        else if(d==3) c +=1;

        if(r<0)     r= row-1;
        if(r>=row)  r= 0;
        if(c<0)     c= col-1;
        if(c>=col)  c= 0;
    }
}