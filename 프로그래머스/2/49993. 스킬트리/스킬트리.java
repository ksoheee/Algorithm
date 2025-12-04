import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int len = skill.length();
        
        List<Character> check;;
        
        for(int i=0; i<skill_trees.length; i++){
            check = new ArrayList<>();
            for(int j=0; j<skill_trees[i].length(); j++){
                for(int k=0; k<len; k++){
                    if(skill_trees[i].charAt(j)==skill.charAt(k)) {
                        check.add(skill_trees[i].charAt(j));
                    }    
                }
            }
            
            boolean flag = true;
            for(int j=0; j<check.size(); j++){
                if(skill.charAt(j) != check.get(j)){
                    flag=false;
                    break; 
                } 
            }
            if(flag) answer++;
        }
        return answer;
    }
}