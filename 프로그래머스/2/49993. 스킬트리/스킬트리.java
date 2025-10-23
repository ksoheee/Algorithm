class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String tree : skill_trees){
            String filter = tree.replaceAll("[^" +skill + "]", "");
            
            if(skill.startsWith(filter)) answer++;
        }
        return answer;
        
    }
}