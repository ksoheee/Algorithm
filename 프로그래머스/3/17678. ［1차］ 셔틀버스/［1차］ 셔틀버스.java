import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;
        //크루 도착시간 정렬
        List<Integer> crews = new ArrayList<>();
        for(String time : timetable){
            String[] s = time.split(":");
            int toMin = Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]); 
            crews.add(toMin);
        }
        Collections.sort(crews);
        
        int busTime = 540; //9:00부터 시작
        int idx = 0; 
        
        for(int i=0; i<n; i++){//허루 셔틀버스 수
            int curN = 0; //한개의 셔틀버스에 탄 인원
            while(idx<crews.size() && crews.get(idx)<=busTime && curN<m){
                idx++;
                curN++;
            }
            
            //마지막 버스라면
            if(i==n-1){
                //좌석이 남아있으면 마지막 버스 탐
                if(curN<m)  answer = busTime;
                //안남아있으면 1분 일찍
                else        answer = crews.get(idx-1)-1;
            }
            
            busTime += t;
        }
        return intToString(answer);
    }
    public String intToString(int t){
        int hour = t/60;
        int minute = t%60;
        return oneToTwo(hour)+":"+oneToTwo(minute);
    }
    public String oneToTwo(int t){
        if(t/10==0){ //한자리수면 
            return "0"+String.valueOf(t);
        }else{
            return String.valueOf(t);
        }
    }
}