import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int n = skill_trees.length;
        
        char[] skillArr = skill.toCharArray();
        
        for(int i=0; i<n; i++){
            Deque<Character> check = new ArrayDeque<>();
            
            //스킬만 삽입
            for(int j=0; j<skill_trees[i].length(); j++){
                for(int k=0; k<skill.length(); k++){
                    if(skill_trees[i].charAt(j)==skill.charAt(k)){
                        check.offerLast(skill_trees[i].charAt(j));
                    }
                }
                
            }
            //판단
            int size = check.size();
            for(int k=0; k<size; k++){
                if(skillArr[k] == check.getFirst()){
                    check.pollFirst();
                }
                //if(skillArr[k] != check.pollFirst()) break;
            }
            if(check.isEmpty()) answer++;
        }
        return answer;
    }
}