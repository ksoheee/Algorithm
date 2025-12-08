import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] pre = new int[n];
        int[] next = new int[n];
        
        //초기값
        for(int i=0; i<n; i++){
            pre[i] = i-1;
            next[i] = i+1;
        }
        next[n-1] = -1;
        //삭제된 행을 저장할 스택
        Deque<int[]> stack = new ArrayDeque<>();
        boolean[] deleted = new boolean[n];
        //현재 위치
        int idx = k;
        
        for(int i=0; i<cmd.length; i++){
            char ch = cmd[i].charAt(0);
            if(ch == 'D'){
                int t = Integer.parseInt(cmd[i].substring(2));
                for(int j=0; j<t; j++) idx = next[idx];
            }else if(ch == 'U'){
                int t = Integer.parseInt(cmd[i].substring(2));
                for(int j=0; j<t; j++) idx = pre[idx];
            }
            else if(ch == 'C'){
                deleted[idx]= true;
                stack.push(new int[]{idx, pre[idx], next[idx]});
                
                //현재 행을 제거
                if(pre[idx]!=-1)    next[pre[idx]] = next[idx];
                if(next[idx]!=-1)   pre[next[idx]] = pre[idx];
                
                //커서 이동
                if(next[idx] != -1) idx = next[idx];
                else                idx = pre[idx];
                
            }else if(ch == 'Z'){
                int[] re = stack.pop();
                int reIdx = re[0];
                int reP = re[1];
                int reN = re[2];
                deleted[reIdx]= false;
                
                if(reP != -1)   next[reP] = reIdx;
                if(reN != -1)   pre[reN] = reIdx;
                
                pre[reIdx] = reP;
                next[reIdx] = reN;
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
