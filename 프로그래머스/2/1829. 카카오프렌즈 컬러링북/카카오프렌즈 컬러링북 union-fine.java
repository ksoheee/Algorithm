import java.util.*;
class Solution {
    int[] parent;
    int[] size;
    int[] dy ={-1,1,0,0};
    int[] dx = {0,0,-1,1};
    int M,N;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        M = m; N = n;
        int total = m*n;
        parent = new int[total];
        size = new int[total];
        
        for(int i=0; i<total; i++){
            parent[i]=i; //자기 자신이 부모
            size[i]=1;  //초기화시 사이즈 모두 1
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0){
                    int current = i*n+j;
                    
                    for(int k=0; k<4; k++){
                        int ny = i+dy[k];
                        int nx = j+dx[k];

                        if(ny<0 || nx<0 || ny>=M || nx>=N) continue;
                        
                        //같은 숫자면
                        if(picture[i][j] == picture[ny][nx]){
                             int next = ny*n+nx;
                            union(current, next);
                        }
                    }
                }
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]==0) continue;
                
                int node = i*N+j;
                int root = find(node);
                
                map.put(root, map.getOrDefault(root,0)+1);
            }
        }
        
        numberOfArea = map.size();
        for(int v : map.values()){
            maxSizeOfOneArea = Math.max(maxSizeOfOneArea, v);
        }
           
        return new int[]{numberOfArea,maxSizeOfOneArea};
    }
    public int find(int a){
        if(parent[a]==a) return a;
        return parent[a]= find(parent[a]);
    }    
    public void union(int cur, int next){
        int rootA = find(cur);
        int rootB = find(next);
        
        if(rootA!=rootB){
            if(size[rootA]<size[rootB]){
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
            else{
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            } 
        }
    }
}
