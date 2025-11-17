import java.util.*;
import java.io.*;
class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : number.toCharArray()){
            while(!stack.isEmpty() && stack.peekLast()<c && k>0){
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }
        //모든 숫자 처리 후 k남아있다면
        for(int i=0; i<k; i++){
            stack.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }
        
        return sb.toString();
    }
}