import java.util.*;
class Solution {
    static int[] discountRate = {10,20,30,40};
    static int maxPrice;
    static int maxPlus;
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, new int[emoticons.length], users, emoticons);
        return new int[] {maxPlus, maxPrice};
    }
    
    public void dfs(int index, int[] rates, int[][] users, int[] emoticons){
        if(index == emoticons.length){
            evaluate(rates,users,emoticons);
            return;
        }
        for(int d : discountRate){
            rates[index] = d;
            dfs(index+1,rates, users,emoticons);
        }
        
    }
    public void evaluate(int rates[],int[][] users, int[] emoticons){
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
        if(maxPlus< plus || (maxPlus == plus && maxPrice<totalprice)){
                maxPlus = plus;
                maxPrice = totalprice;
            }
    }

}