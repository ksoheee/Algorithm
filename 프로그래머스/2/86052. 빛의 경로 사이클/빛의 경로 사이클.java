import java.util.*;
class Solution {
    //상하좌우 0,1,2,3
    int[] L = {2,3,1,0};
    int[] R = {3,2,0,1};
    //방문한 곳을 또 방문하게 되면 사이클 종료 
    boolean[][][] visited;
    char[][] ch;
    int r,c,d;
    int cnt; //사이클 경로 수 
    int row, col;
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        row = grid.length;
        col = grid[0].length();
        
        visited = new boolean[row][col][4];//마지막은 방향이므로 4
        ch = new char[row][col];
        for(int i=0; i<row; i++){
            ch[i] = grid[i].toCharArray();
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                for(int k=0; k<4; k++){
                    if(!visited[i][j][k]){
                        cnt = 0;
                        r = i; c = j; d = k;
                        cycle();
                        
                        answer.add(cnt); //사이클 저장
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
    }
    //격자 확인해서 방향 전환
    public void cycle(){
        while(!visited[r][c][d]){
            visited[r][c][d] = true;
            cnt++;
            
            if(ch[r][c]=='L'){
                d = L[d];
            }else if(ch[r][c]=='R'){
                d = R[d];
            }
            move();
        }
    }
    public void move(){
        if(d==0)        r -=1;
        else if(d==1)   r +=1;
        else if(d==2)   c -=1;
        else if(d==3)   c +=1;
        
        if(r<0)     r= row-1;
        if(r>=row)  r= 0;
        if(c<0)     c= col-1;
        if(c>=col)  c= 0;
    }
}