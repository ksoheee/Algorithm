class Solution {
    boolean[] visited;
    int answer;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return answer;
    }
    void dfs(int current, int[][] dungeons, int cnt){
        answer = Math.max(answer, cnt);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0]<=current){
                visited[i]=true;
                dfs(current-dungeons[i][1], dungeons, cnt+1);
                visited[i]=false;
            }
        }
    }
}