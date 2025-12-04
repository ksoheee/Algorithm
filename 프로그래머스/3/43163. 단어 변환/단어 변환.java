import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        //word에 target단어 없으면 바로 반환
        boolean flag = false;
        for(String w: words){
            if(w.equals(target)){
                flag = true;
                break;
            }
        }
        if(!flag) return 0;
        
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        //처음 단어 큐에 추가
        q.offer(new Node(begin,0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            //target 단어와 같으면 끝
            if(cur.word.equals(target)) return cur.step;
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && check(words[i], cur.word)){
                    visited[i]=true;
                    q.offer(new Node(words[i], cur.step+1));
                }
            }
        }
        //다 돌았는데도 없으면 
        return 0;
    }

    //한개의 알파벳만 다른지 확인
    public boolean check(String a, String b){
        int cnt = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        if(cnt>1) return false;
        return true;
    }
}
class Node{
    String word; 
    int step;       //단계
    
    Node(String word, int step){
        this.word = word;
        this.step = step;
    }
}