import java.util.*;
class Solution {
    private static final int[] discountRate = {10,20,30,40};
    static int maxPrice;
    static int maxPlus;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] result = dfs(0, new int[emoticons.length], users, emoticons);
        return result;
    }
    
    public int[] dfs(int index, int[] rates, int[][] users, int[] emoticons){
        if(index == emoticons.length){
            return evaluate(rates,users,emoticons);
            
        }
        int[] result = {0,0}; //가입자수, 매출
        for(int d : discountRate){
            rates[index] = d;
            int[] candidate = dfs(index+1,rates, users,emoticons);
            
            if(candidate[0]>result[0] ||(candidate[0]==result[0] && candidate[1]>result[1])){
                result = candidate;
            }
            
        }
        return result;
        
    }
    public int[] evaluate(int rates[],int[][] users, int[] emoticons){
        int totalprice=0; int plus=0;
        
        for(int[] user: users){
            int userRate = user[0];
            int limitPrice = user[1];
            int price=0;
            for(int i=0; i<emoticons.length; i++){
                if(userRate<=rates[i]){
                    price +=emoticons[i]/100 * (100-rates[i]);
                }
            }
            if(limitPrice<=price){
                plus++;
            }else{
                totalprice += price;
            }
        }
        return new int[] {plus, totalprice};
    }

}
