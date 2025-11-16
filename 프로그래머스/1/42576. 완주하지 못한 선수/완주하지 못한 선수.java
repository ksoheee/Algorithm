import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        //참가한 사람
        for(String p : participant){
            map.put(p, map.getOrDefault(p,0)+1);
        }
        //완주한사람
        for(String c : completion){
            map.put(c, map.get(c)-1);
        }
        //완주못한사람
        for(String key: map.keySet()){
            if(map.get(key) !=0){
                return key;
            }
        }
        return "";
    }
}