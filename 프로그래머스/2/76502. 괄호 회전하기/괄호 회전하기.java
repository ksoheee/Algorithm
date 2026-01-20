import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int len = s.length();
        for(int i=0; i<len; i++){
            String rotated = rotate(s,i);
            
            if(check(rotated)) answer++;
        }
        return answer;
    }
    //문자열 회전
    public String rotate(String s, int k){
        return s.substring(k)+s.substring(0,k);
    }
    //올바른지 확인
    public boolean check(String s){
        Deque<Character> dq = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            //여는 괄호가 나오면 스택push
            if(ch=='(' || ch=='{' || ch=='[') dq.push(ch);
            
            else{
                //닫는 괄호가 나왔는데 비어있다면 올바르지 않음
                if(dq.isEmpty()) return false;
                char pop = dq.pop();
                
                if(ch==')' && pop != '(') return false;
                if(ch=='}' && pop != '{') return false;   
                if(ch==']' && pop != '[') return false;
            }
        }
        //끝났을때 스택이 비어있어야 함
        return dq.isEmpty();
    }
}