import java.util.*;
class Solution {
    public int[] solution(String s) {
        //{{,}} 제거
        s = s.substring(2, s.length()-2);
        
        //},{제거
        String[] arr = s.split("\\},\\{");
        
        //길이 순으로 정렬
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String o1, String o2){
                return o1.length()-o2.length();
            }
        });
        
        List<Integer> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(String str : arr){
            String[] nums = str.split(",");
            
            for(String num : nums){
                int n = Integer.parseInt(num);
                
                if(!set.contains(n)){
                    set.add(n);
                    answer.add(n);
                }
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}