import java.util.*;
class Solution {
    //지원자 1명에 대해 조건을 쓰거나 -로 바꾸는 경우의 수를 모두 저장 2^4 = 16
    //List에는 같은 경우의 수에 대해 코테 점수를 정렬해서 저장
    Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        //info
        for(String s : info){
            String[] str = s.split(" ");
            String[] apply = {str[0],str[1],str[2],str[3]};
            int score = Integer.parseInt(str[4]);
            
            //지원자 정보 map에 저장
            makeApplyInfo(0, "",  apply, score);
        }
        
        //map안의 list의 점수들 정렬
        for(List<Integer> list : map.values()){
            Collections.sort(list);
        }
        
        //query
        for(int i=0; i<query.length; i++){
            //공백으로 구분하여 나누기 위해 and를 공백으로 교체
            String str = query[i].replaceAll(" and ", " ");
            String[] q = str.split(" ");
            
            String key = q[0]+q[1]+q[2]+q[3];
            int targetScore = Integer.parseInt(q[4]);
            
            //일치하는 정보가 없으면 0명
            if(!map.containsKey(key)){
                answer[i] = 0;
                continue;
            }
            
            List<Integer> list = map.get(key);
            //target점수 이상인 사람의 수를 구하기 위해 
            //target점수 이상이 처음 나오는 위치를 구하여 최적화 
            int cnt = lowerBound(list, targetScore);
            answer[i] = list.size()-cnt;
        }
        return answer;
    }
    
    void makeApplyInfo(int dep, String applyinfo, String[] apply, int score){
        if(dep==4){
            if(!map.containsKey(applyinfo)){
                map.put(applyinfo, new ArrayList<>());
            }
            map.get(applyinfo).add(score);
            return;
        }
        //가능한 경우의 수 조건이 있을때와 - 일때 
        makeApplyInfo(dep+1, applyinfo+apply[dep], apply, score);
        makeApplyInfo(dep+1, applyinfo+"-", apply, score);
    }
    
    int lowerBound( List<Integer> list, int target){
        int left=0; int right = list.size();
        
        while(left<right){
            int mid = (left+right)/2;
            
            if(list.get(mid)>= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
