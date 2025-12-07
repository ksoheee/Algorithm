import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int len = s.length();
        StringBuilder sb;
        
        if(len==1) return 1;
        
        //몇개의 갯수로 잘라야 하는지 
        for(int i=1; i<=len/2; i++){
            sb = new StringBuilder();
            String pre = s.substring(0,i);
            int cnt=1;
            String tmp ="";
            for(int j=i; j<=len-i; j+=i){
                tmp = s.substring(j,j+i);
                
                if(pre.equals(tmp)){
                    cnt++;
                }
                else{
                    if(cnt<2)  sb.append(pre);
                    else        sb.append(String.valueOf(cnt)).append(pre);
                    pre = tmp;
                    cnt = 1;
                }
               
            }
            //마지막 추가
            if(cnt<2)  sb.append(tmp);
            else        sb.append(String.valueOf(cnt)).append(tmp);
            
            //나머지 문자열
            if(len%i!=0){
                String r = s.substring(len-(len%i),len);
                sb.append(r);
            }
            answer = Math.min(answer, sb.toString().length());
            
        }
        
        return answer;
    }
}