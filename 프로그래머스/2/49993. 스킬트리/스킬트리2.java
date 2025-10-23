class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String tree : skill_trees){
            int index = 0;
            boolean isValid = true;
            for(char t : tree.toCharArray()){
                int pos = skill.indexOf(t);
                if(pos == -1) continue;     //스킬이 아닌 문자는 무시 
                
                if(pos == index){//스킬과 순서가 같을때
                    index++;
                }else if(pos>index){
                    isValid = false;
                    break;
                }
            }
            if(isValid) answer++;
        }
        return answer;
        
    }
}
