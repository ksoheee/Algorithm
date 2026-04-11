import java.util.*;
class Solution {
    int len;
    int cnt;
    int num;
    boolean visited[];
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        len = numbers.length();
        char[] ch = new char[len];
        
        for(int i=0; i<len; i++){
            ch[i] = numbers.charAt(i);
        }
        
        for(int i=1; i<=len; i++){
            visited = new boolean[len];
            dfs(ch, 0, i, 0);
        }
        return cnt;
    }
    void dfs(char[] ch, int dep, int g, int current){
        if(dep==g){
            //소수라면 cnt++ 
            if(!set.contains(current)) set.add(current);
            else return;
            
            if(check(current)) cnt++;
            return;
        }
        for(int i=0; i<len; i++){
            if(!visited[i]){
                visited[i]=true;
                
                int next = current * 10 + (ch[i] - '0');
                dfs(ch, dep + 1, g, next);
                
                visited[i]=false;
            }
        }
    }
    //소수 확인
    boolean check(int checkNum){
        if(checkNum<2) return false;
        
        int mid = (int) Math.sqrt(checkNum);
        for(int i=2; i<=mid; i++){
            if(checkNum%i==0) return false;
        }
        return true;
    }
    
}