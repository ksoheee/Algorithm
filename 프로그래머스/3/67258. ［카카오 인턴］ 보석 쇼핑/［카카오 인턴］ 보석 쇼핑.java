import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<gems.length; i++){
            set.add(gems[i]);
        }
        int size = set.size(); //포함해야하는 최소 보석 개수
        int left =0; int right=0; 
        int len = Integer.MAX_VALUE;
        
        while(right<gems.length){
            map.put(gems[right],map.getOrDefault(gems[right],0)+1);
  
            while(map.get(gems[left])>1){
                map.put(gems[left],map.get(gems[left])-1);
                left++;
            }
            
            if(map.size()==size && len>(right-left)){
                len = right-left; 
                answer[0]=left+1;
                answer[1]=right+1;
            }
            right++; 
        }
        return answer;
    }
}