import java.util.*;
class Solution {
    public int solution(String s) {
        int length = s.length();
        if(length == 1) return 1;
        
        String prev = "";
        int answer = length;
        //압축 단위를 1~length/2까지 
        for(int unit = 1; unit<=length/2; unit++){
            prev = s.substring(0,unit); //첫 조각
            int cnt = 1; int resultLen = 0;
            int remain = length% unit;
            
            for(int j = unit; j+unit <= length; j+=unit){
                if(prev.equals(s.substring(j, j+unit))) cnt ++;
                else{
                    if(cnt == 1) resultLen += prev.length();
                    else         resultLen += String.valueOf(cnt).length()+prev.length();
                    prev = s.substring(j, j+unit);
                    cnt = 1;
                }
            }
            //마지막 prve 처리
            if(cnt == 1) resultLen += prev.length();
            else         resultLen += String.valueOf(cnt).length()+prev.length();
            
            //남는 문자열 
            resultLen += remain;

            answer = Math.min(resultLen, answer);
        }
        return answer;
    }
}