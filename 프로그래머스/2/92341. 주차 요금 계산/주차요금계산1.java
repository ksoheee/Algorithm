import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        HashMap<String, Integer> inTime = new HashMap<>();      //입차 시각
        HashMap<String, Integer> totalTime = new HashMap<>();   //누적 주차 시간
        
        for(String record: records){
            String[] parts = record.split(" ");
            String timStr = parts[0];
            String carNum = parts[1];
            String type = parts[2];
            
            //입력받은 시간 분으로 계산
            int time = toMinutes(timStr);
            
            //출차라면
            if(type.equals("OUT")){
                int diff = time - inTime.get(carNum);
                totalTime.put(carNum, diff+totalTime.getOrDefault(carNum,0));
                inTime.remove(carNum);
            }else{
                inTime.put(carNum, time);
            }
            
        }
        //출차 안된 차량
        for(String car: inTime.keySet()){
            int diff = toMinutes("23:59") - inTime.get(car);
            totalTime.put(car, diff+totalTime.getOrDefault(car,0));
        }
        //정렬
        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);

        //요금 계산
        answer = new int[cars.size()];
        for(int i=0; i<cars.size(); i++){
            int t = totalTime.get(cars.get(i));
            answer[i]=calculateFee(t, fees);
        }
        return answer;
    }
    static int toMinutes(String timStr){
        String[] tim = timStr.split(":");
        return Integer.parseInt(tim[0])*60+Integer.parseInt(tim[1]);
    }
    static int calculateFee(int time, int[] fees){
        if(time<=fees[0]) return fees[1];
        return fees[1]+(int)Math.ceil((double)(time-fees[0])/fees[2]) * fees[3];
    }
 
}
