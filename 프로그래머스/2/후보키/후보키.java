import java.util.*;
class Solution {
    List<Integer> candidateKey = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int col = relation[0].length;
        int row = relation.length;
        
        //가능한 모든 조합
        for(int i=1; i<(1<<col); i++){
            //최소성
            if(!minimal(i, candidateKey)) continue;
            //유일성
            if(!unique(i,relation)) continue;
            //후보키 추가
            candidateKey.add(i);
        }
        return candidateKey.size();
    }
    public boolean unique(int mark, String[][] relation){
        Set<String> set = new HashSet<>();
        
        for(String[] row : relation){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<row.length; i++){
                if((mark & (1<<i)) !=0 ){
                    sb.append(row[i]).append("|");
                }
            }
            set.add(sb.toString());
        }
        if(set.size()==relation.length) return true;
        return false;
    }
    public boolean minimal(int mark, List<Integer> candidateKey){
        for(int c : candidateKey){
            if((mark & c) == c) return false;
        }
        return true;
    }
   
}
