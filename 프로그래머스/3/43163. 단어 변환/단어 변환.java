import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean flag = false;
        for(String w: words){
            if(w.equals(target)){
                flag = true;
                break;
            } 
        }
        if(!flag) return 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin,0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.word.equals(target)) return cur.step;
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && check(cur.word ,words[i])){
                    visited[i] = true;
                    q.offer(new Node(words[i],cur.step+1));
                }
            }
        }
        return 0;
        
    }
    public boolean check(String a, String b){
        int cnt =0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)) cnt++;
        }
        if(cnt>1) return false;
        return true;
    }
    
}
class Node{
    String word;
    int step;
    
    Node(String word, int step){
        this.word = word;
        this.step = step;
    }
}