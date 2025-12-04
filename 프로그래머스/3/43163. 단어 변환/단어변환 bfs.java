import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        //word에서 target과 같은 단어가 없으면 무조건 실패 
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
        //시작 단어와 단계(0)을 추가
        q.offer(new Node(begin,0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            //target에 도달하면 단계 수 반환
            if(cur.word.equals(target)) return cur.step;
            
            //word 전체 탐색하면서 한글자만 다른 단어 큐에 추가
            for(int i=0; i<words.length; i++){
                if(!visited[i] && check(cur.word ,words[i])){
                    visited[i] = true;
                    q.offer(new Node(words[i],cur.step+1));
                }
            }
        }
        return 0;
        
    }
    //알파벳이 한글자만 다른지 확인 
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
    String word; //단어
    int step;   //단계
    
    Node(String word, int step){
        this.word = word;
        this.step = step;
    }
}
