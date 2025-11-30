import java.util.*;
class Solution {
    List<Set<Integer>> candidateKey = new ArrayList<>();
    public int solution(String[][] relation) {
        //조합 1개일때 2개일때 ...
        for(int i=1; i<=relation[0].length; i++){
            com(0,i,new ArrayList<>(),relation);
        }
        return candidateKey.size();
    }
    public void com(int start, int depth, List<Integer> combo, String[][] relation){
        if(depth==combo.size()){
            check(combo, relation);
            return;
        }
        for(int i=start; i<relation[0].length; i++){
            combo.add(i);
            com(i+1, depth, combo, relation);
            combo.remove(combo.size()-1);
        }
    }
    public void check(List<Integer> combo,String[][] relation){
        //최소성
        for(Set<Integer> s : candidateKey){
            if(combo.containsAll(s)) return;
        }
        //유일성
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<relation.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int c : combo){
                sb.append(relation[i][c]).append("|");
            }
            set.add(sb.toString());
        }
        
        if(set.size()==relation.length){
            candidateKey.add(new HashSet<>(combo));
        }
    }
}