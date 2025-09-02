class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int n=1;
        int arr[][] = new int[rows+1][columns+1];
        for(int i=1; i<=rows; i++){
           for(int j=1; j<=columns; j++){
               arr[i][j] =n;
               n++;
           }
        }
        
        int size = queries.length;
        int[] answer = new int[size];
        for(int i=0; i<size; i++){
            int startX = queries[i][0];
            int startY = queries[i][1];
            int endX = queries[i][2];
            int endY = queries[i][3];
            
            int tmp = arr[startX][startY];
            int min = tmp;
            
            //1
            for(int j=startX; j<endX; j++){
                arr[j][startY]=arr[j+1][startY];
                min = Math.min(arr[j][startY],min);
                
            }
            //2
            for(int j=startY; j<endY; j++){
                arr[endX][j]=arr[endX][j+1];
                min = Math.min(arr[endX][j],min);
            }
            //3
            for(int j=endX; j>startX; j--){
                arr[j][endY]=arr[j-1][endY];
                min = Math.min(arr[j][endY],min);
            }
            //4
            for(int j=endY; j>startY+1; j--){
                arr[startX][j]=arr[startX][j-1];
                min = Math.min(arr[startX][j],min);
            }
            arr[startX][startY+1]=tmp;
            min = Math.min(arr[startX][startY+1],min);
            
            answer[i]=min;
        }
        return answer;
    }
}