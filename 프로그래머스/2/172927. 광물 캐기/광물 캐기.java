import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPick = picks[0]+picks[1]+picks[2]; //총 곡갱이 수   
        int totalWork = Math.min((minerals.length+4)/5, totalPick);//총 일하는 수
        
        List<int[]> groups = new ArrayList<>(); 
        //광물은 5개씩 한덩이라고 생각
        //곡갱이 수가 광물의 개수보다 작을 수 있으므로 둘다 조건에 포함
        for(int i=0; i<minerals.length && groups.size()<totalWork; i+=5){
            int dia = 0; int iron = 0; int stone = 0;
            for(int j=i; j<i+5 && j<minerals.length; j++){
                String mineral = minerals[j];
                if(mineral.equals("diamond")){
                    dia++;
                }
                if(mineral.equals("iron")){
                    iron++;
                }
                if(mineral.equals("stone")){
                    stone++;
                }                
            }
            groups.add(new int[]{dia, iron, stone});
        }
        //돌 곡갱이 기준으로 피로도가 높은 순으로 정렬
        groups.sort((a,b)-> {
            int mineralA = a[0]*25 + a[1]*5 + a[2];
            int mineralB = b[0]*25 + b[1]*5 + b[2];
            return mineralB-mineralA;
        });
        
        //곡갱이 배정
        int tired = 0;
        for(int i=0; i<groups.size(); i++){
            int[] g = groups.get(i);
            if(picks[0]>0){
                tired += g[0] + g[1] + g[2];
                picks[0]--;
            }
            else if(picks[1]>0){
                tired += g[0]*5 + g[1] + g[2];
                picks[1]--;
            }
            else if(picks[2]>0){
                tired += g[0]*25 + g[1]*5 + g[2];
                picks[2]--;
            }            
        }
        return tired;
    }
}