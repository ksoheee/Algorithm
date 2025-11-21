import java.util.*;
class Solution {
    HashMap<String, Integer> map; //조합, 등장 횟수
    int max;    // 해당 course 길이에서 가장 많이 등장한 횟수
    public String[] solution(String[] orders, int[] course) {
        int len = orders.length;
        List<String> list = new ArrayList<>();
    
       //각 주문 정렬
        for(int i=0; i<len; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i]= new String(arr);
        }
        //조합 생성
        for(int c : course){
            map = new HashMap<>();
            max = 0;
            
            for(int i=0; i<len; i++){
                char[] arr = orders[i].toCharArray();
                if(arr.length<c) continue;
                
                dfs(arr,0,0, c, new StringBuilder());
            }
            
            //가장 많이 등장한 조합 추가(등장 횟수>=2)
            for(String key : map.keySet()){
                 if(map.get(key) == max && max>=2){
                     list.add(key);
                 }              
            }
        }
        //사전 순 정렬
        Collections.sort(list);
        
        return list.toArray(new String[0]);
        
    }
    //메뉴 조합
    private void dfs(char[] arr, int start, int depth, int targetLen, StringBuilder sb){
        if(depth == targetLen){
            String key = sb.toString();
            map.put(key, map.getOrDefault(key,0)+1);
            max = Math.max(max, map.get(key));
            return;
        }
        
        for(int i=start;i<arr.length; i++){
            sb.append(arr[i]);
            dfs(arr, i+1, depth+1, targetLen, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}