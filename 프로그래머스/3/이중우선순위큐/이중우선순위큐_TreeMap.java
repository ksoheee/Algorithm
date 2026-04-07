import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        for(String s: operations)
        {
            String[] str = s.split(" ");
            String cmd = str[0];
            int value = Integer.parseInt(str[1]);
            
            if(cmd.equals("I")){
                tm.put(value, tm.getOrDefault(value, 0)+1);
            }else {
                if(tm.size()==0) continue;
                
                if(value == 1){
                    //최댓값 삭제
                    int max = tm.lastKey();
                    remove(tm, max);
                } else {
                    //최솟값 삭제
                    int min = tm.firstKey();
                    remove(tm, min);
                }
            }
        }
        
        if(tm.size()==0) return new int[]{0,0};
        else             return new int[]{tm.lastKey(), tm.firstKey()};
    }
    
    public void remove(TreeMap<Integer,Integer> tm, int value){
        if(tm.get(value)==1){
            tm.remove(value);
        }else {
            tm.put(value, tm.get(value)-1);
        }
    }
}
