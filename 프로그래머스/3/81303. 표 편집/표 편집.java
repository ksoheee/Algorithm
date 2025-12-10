import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        
        for(int i=0; i<n; i++){
            prev[i]=i-1;
            next[i]=i+1;
        }
        next[n-1]=-1;
        
        int idx = k; //현재 위치 
        
        Deque<int[]> saveDelete = new ArrayDeque<>();
        boolean[] deleted = new boolean[n];
        
        for(int i=0; i<cmd.length; i++){
            char tmp = cmd[i].charAt(0);
            if(tmp=='U'){
                int c = Integer.parseInt(cmd[i].substring(2));
                for(int j=0; j<c; j++) idx = prev[idx];
            }else if(tmp=='D'){
                int c = Integer.parseInt(cmd[i].substring(2));
                for(int j=0; j<c; j++) idx = next[idx];
            }
            else if(tmp=='C'){
                deleted[idx]=true;
                saveDelete.push(new int[]{idx, prev[idx],next[idx]});
                
                if(prev[idx]!=-1)    next[prev[idx]] = next[idx];
                if(next[idx]!=-1)    prev[next[idx]] = prev[idx];
                
                if(next[idx]!=-1)    idx = next[idx];
                else                 idx = prev[idx];
            }else if(tmp=='Z'){
                int[] re = saveDelete.pop();
                int reIdx = re[0];
                int pIdx = re[1];
                int nIdx = re[2];
                
                deleted[reIdx] = false;
                
                if(pIdx!=-1) next[pIdx] = reIdx;
                if(nIdx!=-1) prev[nIdx] = reIdx;
                
                prev[reIdx] = pIdx;
                next[reIdx] = nIdx;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(deleted[i])  sb.append("X");
            else            sb.append("O");
        }
        return sb.toString();
        
    }
}