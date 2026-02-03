import java.util.*;
class Solution {
    //시간단위는 ms
    //모든 로그의 start, end 
    public int solution(String[] lines) {
        List<int[]> list = new ArrayList<>();
        
        for(int i=0; i<lines.length; i++){
            int end = changeTimeToMs(lines[i].substring(11,23));
            int dist = changeDistTimeToMs(lines[i].substring(24).trim());
            int start = end-dist+1;
            list.add(new int[]{start, end});
        }
        
        int max = 0;
        
        for(int i=0; i<list.size(); i++){
            int secStart = list.get(i)[1];
            int secEnd = list.get(i)[1]+999;
            
            int cnt = 0; 
            for(int j=0; j<list.size(); j++){
                int s = list.get(j)[0];
                int e = list.get(j)[1];
                if(s<=secEnd && e>= secStart) cnt++;
            }
            max = Math.max(max, cnt);
        }
        
        
        return max;
    }
    //end
    int changeTimeToMs(String s){
        int hour = Integer.parseInt(s.substring(0,2))*3600000;
        int min = Integer.parseInt(s.substring(3,5))*60000;
        int sec = Integer.parseInt(s.substring(6,8))*1000;
        int ms = Integer.parseInt(s.substring(9));
        return hour+min+sec+ms;
    }
    //dist
    //부동소수점 오차를 막기 위해 Math.round
    int changeDistTimeToMs(String s){
        int len = s.length();
        int ms =(int)Math.round(Double.parseDouble(s.substring(0,len-1))*1000);
        return ms;
    }
}