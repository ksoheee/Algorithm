import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        char alp = 'A';
        for(int i=1; i<=26; i++){
            map.put(String.valueOf(alp),i); //길이 1 사전 등록
            alp++;
        }
        
        int len = msg.length(); int idx = 0; int end = 0;
        String w = "";
        while(idx <len){
            end = idx+1;
            while(end<=len && map.containsKey(msg.substring(idx, end))){
                end++;
            }
            w = msg.substring(idx, end-1);
            answer.add(map.get(w));
            if(end<=len){
                String wc = w + msg.substring(end-1, end);
                map.put(wc, map.size()+1);
            }
            idx += w.length();
        }
        return answer.stream().mapToInt(i-> i).toArray();
    }
}