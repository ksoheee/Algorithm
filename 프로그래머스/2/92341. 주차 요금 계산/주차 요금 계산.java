import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        
        //기록 테이블 
        List<String[]> cars = new ArrayList<>();
        
        for(String record: records){
            String[] table = record.split(" ");
            String time = table[0];
            String carNum = table[1];
            String type = table[2];
            
            //차량 존재 여부 확인
            int idx = findCarNum(cars, carNum);
            
            if(idx!=-1){//존재할 때
                String[] car = cars.get(idx);
                if(type.equals("OUT")){
                    //입차 출차 시간 계산
                    int use = calcMinute(car[1],time);
                    int total = Integer.parseInt(car[2])+use;
                    car[2]=String.valueOf(total);
                    car[3]="OUT";
                }else{
                    car[1]=time;
                    car[3]="IN";
                }
            }
            else{//새로운 차
                String[] newCar = new String[4];
                newCar[0]=carNum;
                newCar[1]=time;
                newCar[2]="0";
                newCar[3]=type;
                cars.add(newCar);
            }
        }
    
        //출차안한 차량 남아있는지 확인
        confirm(cars);
        //차 번호순으로 정렬
        cars.sort(Comparator.comparing(a->a[0]));
        
        //요금 계산 
        answer = new int[cars.size()]; 
        for(int i=0; i<cars.size(); i++){
            int totalMin = Integer.parseInt(cars.get(i)[2]);
            answer[i]=calculateAmount(totalMin, fees);
        }
        return answer;
    }
    
    static int calculateAmount(int totalMin, int[] fees){
        if(totalMin<=fees[0]) return fees[1];
        double extra= (double)(totalMin-fees[0])/fees[2];
        return fees[1]+(int)Math.ceil(extra)*fees[3];
    }
    
    static void confirm(List<String[]> cars){
        for(String[] car: cars){
            if(car[3].equals("IN")){
                int use = calcMinute(car[1], "23:59");
                car[2]=String.valueOf(Integer.parseInt(car[2]) + use);
                car[3]="OUT";
            }
        }
    }
    
    static int findCarNum(List<String[]> cars, String carNum){
        for(int i=0; i<cars.size(); i++){
            if(cars.get(i)[0].equals(carNum)) return i;     
        }
        return -1;
    }
    
    static int calcMinute(String oldT, String newT){
        String[] nt = newT.split(":");
        String[] ot = oldT.split(":");
        int newTime = (Integer.parseInt(nt[0])*60)+Integer.parseInt(nt[1]);
        int oldTime = (Integer.parseInt(ot[0])*60)+Integer.parseInt(ot[1]);
        return newTime-oldTime;
    }
}