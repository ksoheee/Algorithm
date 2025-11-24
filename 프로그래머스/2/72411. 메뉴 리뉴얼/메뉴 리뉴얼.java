import java.util.*;
class Solution {
    //코스요리,주문횟수
    HashMap<String, Integer> map;
    int max;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        //주문 정렬 (조합이므로)
        for(int i=0; i<orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        
        //조합해야 하는 수만 큼 
        for(int c: course){
            //map, max 갱신
            map = new HashMap<>();
            max = 0;
            //주문선택
            for(int i=0; i<orders.length; i++){
                String o = orders[i];
                if(o.length()<c) continue;
                
                //조합 선택
                combo(o,0,0,c,new StringBuilder());
            }
            //c 조합에서의 최대 주문, 코스요리 선택 
            for(String s:map.keySet()){
                if(map.get(s)==max && max>=2){
                    answer.add(s);
                }
            }
        }
        Collections.sort(answer);
        //배열로 바꾸고 반환
        return answer.toArray(new String[0]);
        
    }
    public void combo(String o, int start, int depth, int c, StringBuilder sb){
        if(depth == c){
            String t = sb.toString();
            //메뉴 조합 저장
            map.put(t, map.getOrDefault(t, 0)+1);
            //최댓값(주문 수)계산
            max = Math.max(max, map.get(t));
            return;
        }
        for(int i =start; i<o.length(); i++){
            sb.append(o.charAt(i)); //문자 추가 하여 조합 생성
            combo(o,i+1, depth+1, c, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}