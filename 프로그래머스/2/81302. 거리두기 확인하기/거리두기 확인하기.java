class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++){
            int res = 1;
            char[][] place = new char[5][5];
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    place[j][k] = places[i][j].charAt(k);
                }
            }
            
            aaa : for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(place[j][k]=='X') continue;
                    int pcnt = 0;
                    if(place[j][k]=='P') pcnt++;
                    
                    for(int m=0; m<4; m++){
                        int ny = j+dy[m];
                        int nx = k+dx[m];
                        
                        if(ny<0 || nx<0 || ny>=5 || nx>=5) continue;
                        if(place[ny][nx]=='P') pcnt++;
                        
                        if(pcnt>=2){
                            res=0;
                            break aaa;
                        }
                    }
                }
            }
            answer[i]=res;
        }
        return answer;
    }
}