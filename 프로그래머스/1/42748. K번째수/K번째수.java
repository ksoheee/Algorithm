import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> list;
        
        for(int m=0; m<commands.length; m++){
            list = new ArrayList<>();
            int i = commands[m][0];
            int j = commands[m][1];
            int k = commands[m][2];
            
            for(int u=i-1; u<j; u++){
                list.add(array[u]);
            }
            Collections.sort(list);
            answer.add(list.get(k-1));
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}