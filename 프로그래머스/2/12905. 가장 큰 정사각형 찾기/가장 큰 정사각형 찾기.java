
class Solution
{
    public int solution(int [][]board)
    {
        int Y = board.length;       //행
        int X = board[0].length;  //열
        
        //행또는 열이 1일때
        if(X==1){
            for(int i=0; i<Y; i++){
                if(board[i][0]==1) return 1;
            }
            
        }
        if(Y==1){
            for(int i=0; i<X; i++){
                if(board[0][i]==1) return 1;
            }
        }
        int min=0;
        int max=0;
        for(int i=1; i<Y; i++){
            for(int j=1; j<X; j++){
                if(board[i][j]==1){
                    int left = board[i-1][j];
                    int up = board[i][j-1];
                    int leftUp = board[i-1][j-1];
                    min = Math.min(left, Math.min(up, leftUp));
                    board[i][j]= min+1;
                    max = Math.max(max, min+1);
                }
            }
        }


        return max*max;
    }
}